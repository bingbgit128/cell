package com.d3.cell.mapper;

import com.d3.cell.entity.DevDevice;
import com.d3.cell.entity.DevDeviceWithBLOBs;
import com.d3.cell.entity.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DevDeviceMapper {

    int deleteByPrimaryKey(Long ngId);

    int insert(DevDeviceWithBLOBs record);

    int insertSelective(DevDeviceWithBLOBs record);

    DevDeviceWithBLOBs selectByPrimaryKey(Long ngId);

    List<Map<String,Object>> selectPage();
    List<DevDevice> selectByCondition(String sn);

    int updateByPrimaryKeySelective(DevDeviceWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DevDeviceWithBLOBs record);

    int updateByPrimaryKey(DevDevice record);
}