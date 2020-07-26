package com.d3.cell.service;

import com.d3.cell.entity.DevDevice;
import com.d3.cell.util.PageRequest;
import com.d3.cell.util.PageResult;
import com.d3.cell.vo.DevDeviceVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface DevDeviceService {
    PageResult selectPage(PageRequest page);

    /**
     *  查询设备所有 检测着数据
     * @param sn 设备号
     * @return
     */
    List<DevDeviceVo> selectByCondition(String sn, String startTime, String endTime, HttpServletRequest request);



}
