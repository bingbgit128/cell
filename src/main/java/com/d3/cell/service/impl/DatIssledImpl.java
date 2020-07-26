package com.d3.cell.service.impl;

import com.d3.cell.entity.DatIssledWithBLOBs;
import com.d3.cell.entity.ResponseResult;
import com.d3.cell.enums.ResultCode;
import com.d3.cell.mapper.DatIssledMapper;
import com.d3.cell.mapper.DatPacientMapper;
import com.d3.cell.mapper.DevDeviceMapper;
import com.d3.cell.service.DatIssledService;
import com.d3.cell.service.DatIssledService;
import com.d3.cell.util.PageRequest;
import com.d3.cell.util.PageResult;
import com.d3.cell.util.PageUtils;
import com.d3.cell.vo.DatIssledVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DatIssledImpl implements DatIssledService {
    private Logger logger = LoggerFactory.getLogger(DatIssledImpl.class);
    @Autowired
    private DatIssledMapper datIssledMapper;
    @Autowired
    private DatPacientMapper datPacientMapper;

    @Autowired
    private DevDeviceMapper devDeviceMapper;

    @Override
    public PageResult selectPage(PageRequest page) {
        int pageNum = page.getPageNum();
        int pageSize = page.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<DatIssledWithBLOBs> deviceWithBLOBs = datIssledMapper.selectPage();
        PageInfo<DatIssledWithBLOBs> pageInfo = new PageInfo<>(deviceWithBLOBs);
        PageResult pageResult = PageUtils.getPageResult(page, pageInfo);
        return pageResult;
    }

    @Override
    public PageResult selectPageByCondition(PageRequest page, String sn, String startTime, String endTime) {
        int pageNum = page.getPageNum();
        int pageSize = page.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<DatIssledVo> datIssledVoList = datIssledMapper.selectPageByCondition(sn, startTime, endTime);
        PageInfo<DatIssledVo> pageInfo = new PageInfo<>(datIssledVoList);
        ;
        for (DatIssledVo v : pageInfo.getList()) {

        }
        PageResult pageResult = PageUtils.getPageResult(page, pageInfo);
        return pageResult;
    }

    @Override
    public List<DatIssledVo> selectByCondition(String pacientIds, String startTime, String endTime) {
        return datIssledMapper.selectByCondition(pacientIds, startTime, endTime);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult deleteByConditions(String sn, String dateTime) {
        ResponseResult result = null;
        Map<String, Object> map = new HashMap<>();
        try {

            if (devDeviceMapper.selectByCondition(sn).size() <= 0) {
                return ResponseResult.makeERRResult(ResultCode.FAIL, "未查询到设备信息，请检测设备号是否正确");
            }
            ;
            /**
             * 1 查询被检测者的集合
             */
            List<String> datPacientIds = datPacientMapper.selectIdsBySn(sn);
            String[] datPacientArray = new String[datPacientIds.size()];
            datPacientIds.toArray(datPacientArray);
            // 获取检测记录信息
            if (datPacientArray.length <= 0) {
                return ResponseResult.makeERRResult(ResultCode.FAIL, "未查询到此设备有检测者信息,请确认此设备信息");
            }
            List<String> datIssledIds = datIssledMapper.selectNgIds(datPacientArray, null);
            String[] datIssledArray = new String[datIssledIds.size()];
            datIssledIds.toArray(datIssledArray);
            if (datIssledArray.length > 0) {
                // 删除检查记录
                datIssledMapper.deleteDatIssledByPacientId(datPacientArray);
                map.put("datIssledCount", datIssledArray.length);
                if (datIssledMapper.selectNgIds(datPacientArray, null).size() > 0) {
                    logger.info("删除后剩余记录：" + datIssledMapper.selectNgIds(datPacientArray, null).toString());
                } else {
                    // 删除检测者信息
                    datPacientMapper.deleteDatPacient(datPacientArray);
                    map.put("datPacientCount", datPacientArray.length);
                    // 删除设备信息
                    devDeviceMapper.deleteDevDevService(sn);
                    map.put("devDeviceCount", 1);
                }
            } else {
                return ResponseResult.makeERRResult(ResultCode.FAIL, "未查询到此设备相关检测者的检测记录");
            }
            result = ResponseResult.makeOKResult("删除成功", map);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result = ResponseResult.makeERRResult(ResultCode.FAIL, "删除数据发生异常");
        }
        return result;
    }
}
