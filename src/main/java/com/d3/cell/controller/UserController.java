package com.d3.cell.controller;

import com.d3.cell.entity.ResponseResult;
import com.d3.cell.entity.SysUser;
import com.d3.cell.service.SysUserService;
import com.d3.cell.util.PageRequest;
import com.d3.cell.util.PageResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("get/{id}")
    @ResponseBody
   public ResponseResult<SysUser> loadUsers(@PathVariable Integer id){
        SysUser user = sysUserService.findById(Long.valueOf(id));
       return ResponseResult.makeOKResult(user);
   };
    @RequestMapping("getAll")
    @ResponseBody
    public ResponseResult getAll(HttpServletRequest request){
        String  pageNum = request.getParameter("pageNum");
        String  pageSize = request.getParameter("pageSize");
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageNum(Integer.valueOf(pageNum));
        pageRequest.setPageSize(Integer.valueOf(pageSize));
        PageResult result= sysUserService.selectPage(pageRequest);
        return ResponseResult.makeOKResult(result);
    };
}
