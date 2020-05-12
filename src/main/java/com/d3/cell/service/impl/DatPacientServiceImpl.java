package com.d3.cell.service.impl;

import com.d3.cell.mapper.DatPacientMapper;
import com.d3.cell.service.DatPacientService;
import com.d3.cell.vo.DatPacientVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DatPacientServiceImpl implements DatPacientService {

    private Logger logger = LoggerFactory.getLogger(DatPacientServiceImpl.class);

    @Autowired
    private DatPacientMapper datPacientMapper;

    @Override
    public List<DatPacientVo> selectByCondition(String ngIds) {

        // 查询所有数据
        return datPacientMapper.selectByCondition(ngIds);
    }
}
