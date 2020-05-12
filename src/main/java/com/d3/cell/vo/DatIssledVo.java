package com.d3.cell.vo;

import java.io.InputStream;

public class DatIssledVo {

    private Long ngId;
    private String szName;
    private Long ngPacientId;
    private String dtDate;
    private String tmTime;

    public Long getNgId() {
        return ngId;
    }

    public void setNgId(Long ngId) {
        this.ngId = ngId;
    }

    public String getSzName() {
        return szName;
    }

    public void setSzName(String szName) {
        this.szName = szName;
    }

    public Long getNgPacientId() {
        return ngPacientId;
    }

    public void setNgPacientId(Long ngPacientId) {
        this.ngPacientId = ngPacientId;
    }

    public String getDtDate() {
        return dtDate;
    }

    public void setDtDate(String dtDate) {
        this.dtDate = dtDate;
    }

    public String getTmTime() {
        return tmTime;
    }

    public void setTmTime(String tmTime) {
        this.tmTime = tmTime;
    }
}
