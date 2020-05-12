package com.d3.cell.service;

import com.d3.cell.vo.DatPacientVo;

import java.util.List;

public interface DatPacientService {

    List<DatPacientVo> selectByCondition(String ngIds);
}
