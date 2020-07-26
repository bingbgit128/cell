package com.d3.cell.controller;


import com.d3.cell.entity.ResponseResult;
import com.d3.cell.enums.ResultCode;
import com.d3.cell.service.DatIssledService;
import com.d3.cell.service.DevDeviceService;
import com.d3.cell.service.SysUserService;
import com.d3.cell.util.DateUtils;
import com.d3.cell.util.PageRequest;
import com.d3.cell.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    /**
     * 删除检测记录, 删除被检测着 再删除登记信息
     * @param request
     * @return
     */
    @RequestMapping(value = "deleteDatlssledByConditions", method = RequestMethod.POST)
    @ResponseBody
//
    public ResponseResult findBySn(HttpServletRequest request) {
        String sn = request.getParameter("sn");
        String secretKey = request.getParameter("secretKey");
        if(StringUtils.isEmpty(sn)) {
            return ResponseResult.makeERRResult(ResultCode.FAIL,"设备号不能为空");
        }
        if(StringUtils.isEmpty(secretKey)) {
            return ResponseResult.makeERRResult(ResultCode.FAIL,"密钥不能为空");
        }
        try {
            String key = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            if (!key.equals(secretKey)) {
                return ResponseResult.makeERRResult(ResultCode.FAIL,"请输入正确的密钥");
            }
        } catch (Exception e) {
            return ResponseResult.makeERRResult(ResultCode.FAIL,"密钥检测失败");
        }

        return datIssledService.deleteByConditions(sn,null);
    }
}
