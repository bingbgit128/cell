package com.d3.cell.service;

import com.d3.cell.entity.ResponseResult;

import java.util.Map;

public interface TokenService {

    ResponseResult oauthToken(Map<String,Object> map);
}
