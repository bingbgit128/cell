package com.d3.cell.controller;

import com.d3.cell.entity.ResponseResult;
import com.d3.cell.enums.ResultCode;
import com.d3.cell.service.CacheService;
import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;
    @RequestMapping(value = "getAll",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult getFlagsBySN(HttpServletRequest request){
        return ResponseResult.makeOKResult(cacheService.getCaches());
    }


    @RequestMapping(value = "getBySn",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult getBySn(HttpServletRequest request){
        String sn = request.getParameter("sn");
        if(StringUtils.isEmpty(sn)) {
            return ResponseResult.makeERRResult(ResultCode.FAIL,"设备号不能为空");
        }
        return ResponseResult.makeOKResult(cacheService.getCache(sn));
    }

    @RequestMapping(value = "deleteBySn",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult deleteBySn(HttpServletRequest request){
        String sn = request.getParameter("sn");
        if(StringUtils.isEmpty(sn)) {
            return ResponseResult.makeERRResult(ResultCode.FAIL,"设备号不能为空");
        }
        return ResponseResult.makeOKResult(cacheService.deleteCache(sn));
    }

    @RequestMapping(value = "deleteAll",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult deleteAll(HttpServletRequest request){
        cacheService.deleteAll();
        return ResponseResult.makeOKResult("清空标识","");
    }

    @RequestMapping(value = "updateBySn",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult updateBySn(HttpServletRequest request){
        String sn = request.getParameter("sn");
        if(StringUtils.isEmpty(sn)) {
            return ResponseResult.makeERRResult(ResultCode.FAIL,"设备号不能为空");
        }
        String flag = request.getParameter("flag");
        if(StringUtils.isEmpty(flag)) {
            return ResponseResult.makeERRResult(ResultCode.FAIL,"请传入标识符");
        }
        for(int i=0; i<3000;i++) {
            cacheService.updateCache(sn+"_"+i,flag);
        }
        return ResponseResult.makeOKResult(cacheService.updateCache(sn,flag));
    }

}
