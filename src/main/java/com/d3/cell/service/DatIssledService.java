package com.d3.cell.service;

import com.d3.cell.entity.ResponseResult;
import com.d3.cell.util.PageRequest;
import com.d3.cell.util.PageResult;
import com.d3.cell.vo.DatIssledVo;

import java.util.List;

public interface DatIssledService {
    PageResult selectPage(PageRequest page);

    /**
     *
     * @param page
     * @param sn
     * @param startTime
     * @param endTime
     * @return
     */
    PageResult selectPageByCondition(PageRequest page,String sn, String startTime, String endTime);

    /**
     *
     * @param pacientIds
     * @param startTime
     * @param endTime
     * @return
     */
    List<DatIssledVo> selectByCondition(String pacientIds, String startTime, String endTime);

    /**
     *  删除检测记录信息 检测者信息 删除 设备登记信息
     */
   public ResponseResult deleteByConditions(String sn, String dateTime);
}
