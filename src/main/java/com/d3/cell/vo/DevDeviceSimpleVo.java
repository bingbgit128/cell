package com.d3.cell.vo;


public class DevDeviceSimpleVo {
    private Long ngId;
    private String szSn;

    public DevDeviceSimpleVo() {
    }

    public DevDeviceSimpleVo(Long ngId, String szSn) {
        this.ngId = ngId;
        this.szSn = szSn;
    }

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
        this.szSn = szSn;
    }

    @Override
    public String toString() {
        return "DevDeviceSimpleVo{" +
                "ngId=" + ngId +
                ", szSn='" + szSn + '\'' +
                '}';
    }
}
