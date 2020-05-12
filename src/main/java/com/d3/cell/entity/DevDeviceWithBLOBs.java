package com.d3.cell.entity;

public class DevDeviceWithBLOBs extends DevDevice {
    private String txAdminRemark;

    private String szSalesRemark;

    public String getTxAdminRemark() {
        return txAdminRemark;
    }

    public void setTxAdminRemark(String txAdminRemark) {
        this.txAdminRemark = txAdminRemark == null ? null : txAdminRemark.trim();
    }

    public String getSzSalesRemark() {
        return szSalesRemark;
    }

    public void setSzSalesRemark(String szSalesRemark) {
        this.szSalesRemark = szSalesRemark == null ? null : szSalesRemark.trim();
    }
}