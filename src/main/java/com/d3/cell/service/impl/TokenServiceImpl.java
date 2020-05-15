package com.d3.cell.service.impl;

import com.d3.cell.entity.ResponseResult;
import com.d3.cell.enums.ResultCode;
import com.d3.cell.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.Map;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private Environment env;

    @Override
    public ResponseResult oauthToken(Map<String, Object> map) {
        MultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
        if (StringUtils.isEmpty(map.get("username")) || StringUtils.isEmpty(map.get("username"))) {
            return ResponseResult.makeERRResult(ResultCode.FAIL, "账户或密码不能为空");
        }
        paramsMap.set("username", String.valueOf(map.get("username")));
        paramsMap.set("password", String.valueOf(map.get("password")));
        paramsMap.set("grant_type", env.getProperty("cell.grant_type"));
        paramsMap.set("scope", "all");
        String client_id = env.getProperty("cell.client_id");
        String client_secret = env.getProperty("cell.client_secret");
        RestTemplate restTemplate = new RestTemplate();
        OAuth2AccessToken token = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Basic " + Base64Utils.encodeToString(new String(client_id + ":" + client_secret).getBytes("UTF-8")));
            HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity(paramsMap, headers);
            token = restTemplate.postForObject(env.getProperty("cell.oauthUrl"), httpEntity, OAuth2AccessToken.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.makeERRResult(ResultCode.FAIL, "获取认证失败");
        }
        return ResponseResult.makeOKResult(token);
    }
}
