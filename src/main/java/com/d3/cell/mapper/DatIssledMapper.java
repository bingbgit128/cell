package com.d3.cell.mapper;

import com.d3.cell.entity.DatIssled;
import com.d3.cell.entity.DatIssledWithBLOBs;
import com.d3.cell.vo.DatIssledVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatIssledMapper {
    int deleteByPrimaryKey(Long ngId);

    int insert(DatIssledWithBLOBs record);

    int insertSelective(DatIssledWithBLOBs record);

    DatIssledWithBLOBs selectByPrimaryKey(Long ngId);

    List<DatIssledWithBLOBs> selectPage();

    /**
     *
     * @param sn 设备号
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    List<DatIssledVo> selectPageByCondition(String sn, String startTime, String endTime);

    List<DatIssledVo> selectByCondition(String ngPacientIds, String startTime, String endTime);

    int updateByPrimaryKeySelective(DatIssledWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DatIssledWithBLOBs record);

    int updateByPrimaryKey(DatIssled record);
}