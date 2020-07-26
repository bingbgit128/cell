package com.d3.cell.mapper;

import com.d3.cell.entity.DatPacient;
import com.d3.cell.entity.DatPacientWithBLOBs;
import com.d3.cell.vo.DatPacientVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DatPacientMapper {
    int deleteByPrimaryKey(Long ngId);

    int insert(DatPacientWithBLOBs record);

    int insertSelective(DatPacientWithBLOBs record);

    DatPacientWithBLOBs selectByPrimaryKey(Long ngId);
    List<DatPacientWithBLOBs> selectPage();

    List<DatPacientVo> selectByCondition(@Param(value="devIds") String devIds);
    int updateByPrimaryKeySelective(DatPacientWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DatPacientWithBLOBs record);

    int updateByPrimaryKey(DatPacient record);

    List<String> selectIdsBySn(@Param(value="sn") String sn);

    void deleteDatPacient(@Param(value="ngIds") String[] ngIds);
}