package com.d3.cell.service;

import com.d3.cell.entity.SysUser;
import com.d3.cell.util.PageRequest;
import com.d3.cell.util.PageResult;
import com.github.pagehelper.PageInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface SysUserService {

    SysUser findById(Long id);
    SysUser findByUserName(String use);

    PageResult selectPage(PageRequest pageRequest);
}
