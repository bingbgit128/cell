package com.d3.cell.entity;

import com.d3.cell.enums.ResultCode;

public class ResponseResult<T> {
    private Integer code;
    private Boolean success;
    private String msg = "操作成功";
    private Object data;
    private Object ext;


    public ResponseResult(){

    }
    public ResponseResult(Integer code, String msg, Object data, Object ext, Boolean success) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.ext = ext;
        this.success = success;
    }

    public static <T> ResponseResult<T> makeOKResult(Object data){
        return  new ResponseResult<T>(ResultCode.SUCCESS.code,"操作成功",data,"",true);
    }
    public static <T> ResponseResult<T> makeOKResult(String msg,Object data){
        return  new ResponseResult<T>(ResultCode.SUCCESS.code,msg,data,"",true);
    }

    public static <T> ResponseResult<T> makeOKResult(String msg,Object data, Object ext){
        return  new ResponseResult<T>(ResultCode.SUCCESS.code,msg,data,"",true);
    }

    public static <T> ResponseResult<T> makeERRResult(ResultCode resultCode,String msg){
        return  new ResponseResult<T>(resultCode.code,msg,"","",false);
    }


    public Object getExt() {
        return ext;
    }

    public void setExt(Object ext) {
        this.ext = ext;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", ext=" + ext +
                ", success=" + success +
                '}';
    }
}
