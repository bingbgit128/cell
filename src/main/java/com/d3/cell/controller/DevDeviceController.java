package com.d3.cell.controller;


import com.d3.cell.entity.ResponseResult;
import com.d3.cell.service.DevDeviceService;
import com.d3.cell.service.SysUserService;
import com.d3.cell.util.PageRequest;
import com.d3.cell.util.PageResult;
import com.d3.cell.vo.DevDeviceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("getAll")
    @ResponseBody
    public ResponseResult getAll(HttpServletRequest request){
        String  pageNum = request.getParameter("pageNum");
        String  pageSize = request.getParameter("pageSize");
        PageRequest page = new PageRequest();
        page.setPageNum(Integer.valueOf(pageNum));
        page.setPageSize(Integer.valueOf(pageSize));
        PageResult result= devDeviceService.selectPage(page);
        return ResponseResult.makeOKResult(result);
    };

    @RequestMapping("findBySn")
    @ResponseBody
    public ResponseResult findBySn(HttpServletRequest request){
        String  sn = request.getParameter("sn");
        List<DevDeviceVo> list = devDeviceService.selectByCondition(sn,request);
        return ResponseResult.makeOKResult(list);
    };


}
