package com.d3.cell.mapper;

import com.d3.cell.entity.DatPacient;
import com.d3.cell.entity.DatPacientWithBLOBs;
import com.d3.cell.vo.DatPacientVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
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
}