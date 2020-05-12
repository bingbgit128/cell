package com.d3.cell.vo;

import java.util.List;

public class DevDeviceVo {
    private Long ngId;
    private String szSn;
    private List<DatPacientVo> list;

    public DevDeviceVo() {
    }

    public DevDeviceVo(Long ngId, String szSn, List<DatPacientVo> list) {
        this.ngId = ngId;
        this.szSn = szSn;
        this.list = list;
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

    public List<DatPacientVo> getList() {
        return list;
    }

    public void setList(List<DatPacientVo> list) {
        this.list = list;
    }
}
