package com.d3.cell.entity;

public class DatPacient {
    private Long ngId;

    private Long ngPacId;

    private String szName;

    private String szAddr;

    private Integer ntGender;

    private Integer ntAge;

    private String szMobile;

    private Long ngUserId;

    private Long ngDevId;

    private Long ngIndDoc;

    private Integer ntRowVersion;

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
        this.szName = szName == null ? null : szName.trim();
    }

    public String getSzAddr() {
        return szAddr;
    }

    public void setSzAddr(String szAddr) {
        this.szAddr = szAddr == null ? null : szAddr.trim();
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
        this.szMobile = szMobile == null ? null : szMobile.trim();
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

    public Long getNgIndDoc() {
        return ngIndDoc;
    }

    public void setNgIndDoc(Long ngIndDoc) {
        this.ngIndDoc = ngIndDoc;
    }

    public Integer getNtRowVersion() {
        return ntRowVersion;
    }

    public void setNtRowVersion(Integer ntRowVersion) {
        this.ntRowVersion = ntRowVersion;
    }
}