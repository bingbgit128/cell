package com.d3.cell.service.impl;

import com.d3.cell.entity.DatIssledWithBLOBs;
import com.d3.cell.mapper.DatIssledMapper;
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

import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public class DatIssledImpl implements DatIssledService {
    private Logger logger = LoggerFactory.getLogger(DatIssledImpl.class);
    @Autowired
    private DatIssledMapper datIssledMapper;

    @Override
    public PageResult selectPage(PageRequest page) {
        int pageNum = page.getPageNum();
        int pageSize = page.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        List<DatIssledWithBLOBs> deviceWithBLOBs = datIssledMapper.selectPage();
        PageInfo<DatIssledWithBLOBs> pageInfo = new PageInfo<>(deviceWithBLOBs);
        PageResult pageResult = PageUtils.getPageResult(page,pageInfo);
        return pageResult;
    }

    @Override
    public PageResult selectPageByCondition(PageRequest page, String sn, String startTime, String endTime) {
        int pageNum = page.getPageNum();
        int pageSize = page.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        List<DatIssledVo> datIssledVoList = datIssledMapper.selectPageByCondition(sn,startTime,endTime);
        PageInfo<DatIssledVo> pageInfo = new PageInfo<>(datIssledVoList);
       ;
        for ( DatIssledVo v: pageInfo.getList()){

        }
        PageResult pageResult = PageUtils.getPageResult(page,pageInfo);
        return pageResult;
    }

    @Override
    public List<DatIssledVo> selectByCondition(String pacientIds, String startTime, String endTime) {
        return  datIssledMapper.selectByCondition(pacientIds,startTime,endTime);
    }
}
