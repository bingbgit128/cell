package com.d3.cell.service;

import com.d3.cell.vo.DatPacientVo;

import java.util.List;
import java.util.Map;

public interface DatPacientService {

    List<DatPacientVo> selectByCondition(String ngIds);
    /**
     *
     * @param sn
     * @return
     */
    List<String> selectIdsBySn(String sn);

}
