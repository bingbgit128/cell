package com.d3.cell.service.impl;

import com.d3.cell.entity.ResponseResult;
import com.d3.cell.entity.SysUser;
import com.d3.cell.mapper.SysUserMapper;
import com.d3.cell.service.SysUserService;
import com.d3.cell.util.PageRequest;
import com.d3.cell.util.PageResult;
import com.d3.cell.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    private Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public SysUser findById(Long id) {
        SysUser user = sysUserMapper.selectByPrimaryKey(id);
       logger.info( user.toString());
        return user;
    }

    @Override
    public SysUser findByUserName(String userName) {
        SysUser user = sysUserMapper.selectByUserName(userName);
        logger.info(user.toString());
        return user;
    }

    @Override
    public PageResult selectPage(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        List<SysUser>  sysUsers = sysUserMapper.selectPage();
        PageInfo<SysUser>  pageInfo = new PageInfo<SysUser> (sysUsers);
        PageResult pageResult = PageUtils.getPageResult(pageRequest,pageInfo);
        return pageResult;
    }

}
