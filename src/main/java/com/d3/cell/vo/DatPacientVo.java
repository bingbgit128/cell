package com.d3.cell.vo;

import java.util.List;
import java.util.Map;

public class DatPacientVo {
    private Long ngId;

    private Long ngPacId;

    private String szName;

    private String szAddr;

    private Integer ntGender;

    private Integer ntAge;

    private String szMobile;

    private Long ngUserId;

    private Long ngDevId;

    private String txEpicrisis;

    private String szCaption;

    private List<DatIssledVo> issList;

    private List<Map<String,String>> imgList;

    public List<Map<String, String>> getImgList() {
        return imgList;
    }

    public void setImgList(List<Map<String, String>> imgList) {
        this.imgList = imgList;
    }




    public DatPacientVo() {
    }


    public Long getNgId() {
        return ngId;
    }

    public void setNgId(Long ngId) {
        this.ngId = ngId;
    }

    public Long getNgPacId() {
        return ngPacId;
    }

    public void setNgPacId(Long ngPacId) {
        this.ngPacId = ngPacId;
    }

    public String getSzName() {
        return szName;
    }

    public void setSzName(String szName) {
        this.szName = szName;
    }

    public String getSzAddr() {
        return szAddr;
    }

    public void setSzAddr(String szAddr) {
        this.szAddr = szAddr;
    }

    public Integer getNtGender() {
        return ntGender;
    }

    public void setNtGender(Integer ntGender) {
        this.ntGender = ntGender;
    }

    public Integer getNtAge() {
        return ntAge;
    }

    public void setNtAge(Integer ntAge) {
        this.ntAge = ntAge;
    }

    public String getSzMobile() {
        return szMobile;
    }

    public void setSzMobile(String szMobile) {
        this.szMobile = szMobile;
    }

    public Long getNgUserId() {
        return ngUserId;
    }

    public void setNgUserId(Long ngUserId) {
        this.ngUserId = ngUserId;
    }

    public Long getNgDevId() {
        return ngDevId;
    }

    public void setNgDevId(Long ngDevId) {
        this.ngDevId = ngDevId;
    }

    public String getTxEpicrisis() {
        return txEpicrisis;
    }

    public void setTxEpicrisis(String txEpicrisis) {
        this.txEpicrisis = txEpicrisis;
    }

    public String getSzCaption() {
        return szCaption;
    }

    public void setSzCaption(String szCaption) {
        this.szCaption = szCaption;
    }

    public List<DatIssledVo> getIssList() {
        return issList;
    }

    public void setIssList(List<DatIssledVo> issList) {
        this.issList = issList;
    }


}
