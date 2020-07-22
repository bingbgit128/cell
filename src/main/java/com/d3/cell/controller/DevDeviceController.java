package com.d3.cell.controller;


import com.d3.cell.entity.ResponseResult;
import com.d3.cell.enums.ResultCode;
import com.d3.cell.service.DevDeviceService;
import com.d3.cell.service.SysUserService;
import com.d3.cell.util.PageRequest;
import com.d3.cell.util.PageResult;
import com.d3.cell.vo.DevDeviceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("api/devDevice")
public class DevDeviceController extends BaseController{

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private DevDeviceService devDeviceService;

    @RequestMapping(value = "getAll",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult getAll(HttpServletRequest request){
        String  pageNum = request.getParameter("pageNum");
         pageNum = (StringUtils.isEmpty(pageNum)?"1":pageNum);
        String  pageSize = request.getParameter("pageSize");
        pageSize = (StringUtils.isEmpty(pageSize)?"10":pageSize);
        PageRequest page = new PageRequest();
        page.setPageNum(Integer.valueOf(pageNum));
        page.setPageSize(Integer.valueOf(pageSize));
        PageResult result= devDeviceService.selectPage(page);
        return ResponseResult.makeOKResult(result);
    };

    @RequestMapping(value = "findBySn", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult findBySn(HttpServletRequest request){
        String  sn = request.getParameter("sn");
        String  startTime = request.getParameter("startTime");
        String  endTime = request.getParameter("endTime");
        if(StringUtils.isEmpty(sn)){
            return ResponseResult.makeERRResult(ResultCode.FAIL,"设备号为空");
        }
        List<DevDeviceVo> list = devDeviceService.selectByCondition(sn,startTime,endTime,request);
        return ResponseResult.makeOKResult(list);
    };


}
