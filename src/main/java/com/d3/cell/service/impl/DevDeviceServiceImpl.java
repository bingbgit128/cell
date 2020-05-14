package com.d3.cell.service.impl;

import com.d3.cell.entity.DevDevice;
import com.d3.cell.entity.DevDeviceWithBLOBs;
import com.d3.cell.entity.SysUser;
import com.d3.cell.mapper.DevDeviceMapper;
import com.d3.cell.service.DatIssledService;
import com.d3.cell.service.DatPacientService;
import com.d3.cell.service.DevDeviceService;
import com.d3.cell.util.IPUtil;
import com.d3.cell.util.PageRequest;
import com.d3.cell.util.PageResult;
import com.d3.cell.util.PageUtils;
import com.d3.cell.vo.DatIssledVo;
import com.d3.cell.vo.DatPacientVo;
import com.d3.cell.vo.DevDeviceVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DevDeviceServiceImpl implements DevDeviceService {
    private Logger logger = LoggerFactory.getLogger(DevDeviceServiceImpl.class);
    @Autowired
    private DevDeviceMapper devDeviceMapper;

    @Autowired
    private DatPacientService datPacientService;

    @Autowired
    private DatIssledService datIssledService;

    @Autowired
    private Environment env;

    @Override
    public PageResult selectPage(PageRequest page) {
        int pageNum = page.getPageNum();
        int pageSize = page.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<DevDeviceWithBLOBs> deviceWithBLOBs = devDeviceMapper.selectPage();
        PageInfo<DevDeviceWithBLOBs> pageInfo = new PageInfo<DevDeviceWithBLOBs>(deviceWithBLOBs);
        PageResult pageResult = PageUtils.getPageResult(page, pageInfo);
        return pageResult;
    }

    @Override
    public List<DevDeviceVo> selectByCondition(String sn,  String startTime, String endTime, HttpServletRequest request) {
        List<DevDevice> list = devDeviceMapper.selectByCondition(sn);
        List<DevDeviceVo> devDeviceVos = new ArrayList<>();
        List<Map<String, String>> urlPath = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        DevDeviceVo deviceVo = new DevDeviceVo();
        StringBuffer buffer = new StringBuffer();
        String snPath = sn;
        for (DevDevice d : list) {
            buffer.append("," + d.getNgId());
            deviceVo.setNgId(d.getNgId());
            deviceVo.setSzSn(d.getSzSn());
        }
        String sharePath = env.getProperty("sharePath");
        String contextPath  = "http://"+ request.getLocalAddr() + ":" + request.getServerPort() + request.getContextPath();
        logger.info("=="+contextPath);
        String ids = buffer.substring(1);
        List<DatPacientVo> datPacientVoList = datPacientService.selectByCondition(ids);
        buffer.setLength(0);
        List<DatIssledVo> datIssledVos = new ArrayList<>();
        for (DatPacientVo d : datPacientVoList) {
            datIssledVos = datIssledService.selectByCondition(String.valueOf(d.getNgId()), startTime, endTime);
            d.setIssList(datIssledVos);
            String path = snPath + "/img/" + d.getSzName();
            d.setImgList(mapList(contextPath,sharePath, path));
        }
        deviceVo.setList(datPacientVoList);
        devDeviceVos.add(deviceVo);
        return devDeviceVos;
    }

    public List<Map<String, String>> mapList(String contextPath, String sharePath, String path) {
        List<Map<String, String>> list = new ArrayList<>();
        File file = new File(sharePath + path);
        File[] fs = file.listFiles();
        Map<String, String> map = new HashMap<>();
        if (!StringUtils.isEmpty(fs) && fs.length > 0) {
            for (File f : fs) {
                if (!f.isDirectory())    //若是目录，则递归打印该目录下的文件
                    map.put("url", contextPath + "/resource/" + path + "/" + f.getName());
                list.add(map);
            }
        }
        return list;
    }

}
