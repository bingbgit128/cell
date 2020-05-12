package com.d3.cell.controller;


import com.d3.cell.entity.ResponseResult;
import com.d3.cell.service.DatIssledService;
import com.d3.cell.service.DevDeviceService;
import com.d3.cell.service.SysUserService;
import com.d3.cell.util.PageRequest;
import com.d3.cell.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/datIssled")
public class DatIssledController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private DatIssledService datIssledService;

    @RequestMapping("getAll")
    @ResponseBody
    public ResponseResult getAll(HttpServletRequest request){
        String  pageNum = request.getParameter("pageNum");
        String  pageSize = request.getParameter("pageSize");
        PageRequest page = new PageRequest();
        page.setPageNum(Integer.valueOf(pageNum));
        page.setPageSize(Integer.valueOf(pageSize));
        PageResult result= datIssledService.selectPage(page);
        return ResponseResult.makeOKResult(result);
    };
    @RequestMapping("findByCondition")
    @ResponseBody
    public ResponseResult findByCondition(HttpServletRequest request){
        String  pageNum = request.getParameter("pageNum");
        String  pageSize = request.getParameter("pageSize");
        String  startTime = request.getParameter("startTime");
        String  endTime = request.getParameter("endTime");
        String  sn = request.getParameter("sn");
        PageRequest page = new PageRequest();
        page.setPageNum(Integer.valueOf(pageNum));
        page.setPageSize(Integer.valueOf(pageSize));
        PageResult result= datIssledService.selectPageByCondition(page,sn,startTime,endTime);
        return ResponseResult.makeOKResult(result);
    };
}
