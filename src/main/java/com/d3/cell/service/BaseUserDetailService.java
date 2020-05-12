package com.d3.cell.service;

import com.d3.cell.entity.SysUser;
import com.d3.cell.mapper.SysUserMapper;
import com.d3.cell.service.impl.SysUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Service
public class BaseUserDetailService implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(BaseUserDetailService.class);
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        logger.info("======="+s);
        logger.info("======="+ DigestUtils.md5DigestAsHex("000000".getBytes()));
        SysUser sysUser = sysUserMapper.selectByUserName(s);
        if(Objects.isNull(sysUser)){
            throw new UsernameNotFoundException("User " + s + " was not found in the database");
        }
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        User user = new User(sysUser.getSzUsername(),sysUser.getSzPassword(),grantedAuthorities);
        return user;
    }
}
