package com.d3.cell.service.impl;

import com.d3.cell.entity.ResponseResult;
import com.d3.cell.enums.ResultCode;
import com.d3.cell.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private Environment env;
    @Override
    public  ResponseResult oauthToken(Map<String,Object> map) {
        MultiValueMap<String,Object> paramsMap=new LinkedMultiValueMap<>();
        paramsMap.set("username",map.get("username"));
        paramsMap.set("password",map.get("password"));
        paramsMap.set("grant_type",env.getProperty("cell.grant_type"));
        paramsMap.set("scope","all");
        String client_id = env.getProperty("cell.client_id");
        String client_secret = env.getProperty("cell.client_secret");
        RestTemplate restTemplate=new RestTemplate();
        OAuth2AccessToken token = null;
        try {
            restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(client_id,client_secret));
            token = (OAuth2AccessToken) restTemplate.postForEntity("http://localhost:8081/cell/oauth/token",paramsMap,OAuth2AccessToken.class);
        } catch (Exception e) {
            e.getMessage();
            return ResponseResult.makeERRResult(ResultCode.FAIL,"获取认证失败");
        }
//        restTemplate.getInterceptors().add( new BasicAuthenticationInterceptor(client_id,client_secret));
//        OAuth2AccessToken token = (OAuth2AccessToken) restTemplate.postForEntity("http://localhost:8081/cell/oauth/token",paramsMap,OAuth2AccessToken.class);
        return  ResponseResult.makeOKResult(token);
    }
}
