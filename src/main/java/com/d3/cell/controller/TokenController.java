package com.d3.cell.controller;

import com.d3.cell.entity.ResponseResult;
import com.d3.cell.entity.SysUser;
import com.d3.cell.mapper.SysUserMapper;
import com.d3.cell.service.TokenService;
import com.d3.cell.service.impl.SysUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("oauth2")
public class TokenController {
    private Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private TokenService tokenService;

    @RequestMapping("token")
    @ResponseBody
    public ResponseResult<List> loadUsers(@RequestParam String userName,@RequestParam String password){
        Map<String,Object> map = new HashMap<>();
        map.put("username",userName);
        map.put("password",password);
        return  tokenService.oauthToken(map);
    };
}
