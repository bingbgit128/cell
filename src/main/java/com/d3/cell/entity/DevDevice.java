package com.d3.cell.entity;

import java.util.Date;

public class DevDevice {
    private Long ngId;

    private String szSn;

    private Long ngUserId;

    private Date tsPlacing;

    private Integer ntSync;

    private String szSalesMan;

    private String szSalesMobile;

    private Long ngLastPacId;

    private Long ngLastIssledId;

    private Integer ntRowVersion;

    public Long getNgId() {
        return ngId;
    }

    public void setNgId(Long ngId) {
        this.ngId = ngId;
    }

    public String getSzSn() {
        return szSn;
    }

    public void setSzSn(String szSn) {
        this.szSn = szSn == null ? null : szSn.trim();
    }

    public Long getNgUserId() {
        return ngUserId;
    }

    public void setNgUserId(Long ngUserId) {
        this.ngUserId = ngUserId;
    }

    public Date getTsPlacing() {
        return tsPlacing;
    }

    public void setTsPlacing(Date tsPlacing) {
        this.tsPlacing = tsPlacing;
    }

    public Integer getNtSync() {
        return ntSync;
    }

    public void setNtSync(Integer ntSync) {
        this.ntSync = ntSync;
    }

    public String getSzSalesMan() {
        return szSalesMan;
    }

    public void setSzSalesMan(String szSalesMan) {
        this.szSalesMan = szSalesMan == null ? null : szSalesMan.trim();
    }

    public String getSzSalesMobile() {
        return szSalesMobile;
    }

    public void setSzSalesMobile(String szSalesMobile) {
        this.szSalesMobile = szSalesMobile == null ? null : szSalesMobile.trim();
    }

    public Long getNgLastPacId() {
        return ngLastPacId;
    }

    public void setNgLastPacId(Long ngLastPacId) {
        this.ngLastPacId = ngLastPacId;
    }

    public Long getNgLastIssledId() {
        return ngLastIssledId;
    }

    public void setNgLastIssledId(Long ngLastIssledId) {
        this.ngLastIssledId = ngLastIssledId;
    }

    public Integer getNtRowVersion() {
        return ntRowVersion;
    }

    public void setNtRowVersion(Integer ntRowVersion) {
        this.ntRowVersion = ntRowVersion;
    }
}