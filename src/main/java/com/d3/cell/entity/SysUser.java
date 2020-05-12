package com.d3.cell.entity;

public class SysUser {
    private Long ngId;

    private String szUsername;

    private String szPassword;

    private String szName;

    private Long ngRegionId;

    private Long ngGroupId;

    private String szMobile;

    private Integer ntKind;

    private Integer ntState;

    private Integer ntDevCount;

    private Integer ntRowVersion;

    private String txRemark;

    public Long getNgId() {
        return ngId;
    }

    public void setNgId(Long ngId) {
        this.ngId = ngId;
    }

    public String getSzUsername() {
        return szUsername;
    }

    public void setSzUsername(String szUsername) {
        this.szUsername = szUsername == null ? null : szUsername.trim();
    }

    public String getSzPassword() {
        return szPassword;
    }

    public void setSzPassword(String szPassword) {
        this.szPassword = szPassword == null ? null : szPassword.trim();
    }

    public String getSzName() {
        return szName;
    }

    public void setSzName(String szName) {
        this.szName = szName == null ? null : szName.trim();
    }

    public Long getNgRegionId() {
        return ngRegionId;
    }

    public void setNgRegionId(Long ngRegionId) {
        this.ngRegionId = ngRegionId;
    }

    public Long getNgGroupId() {
        return ngGroupId;
    }

    public void setNgGroupId(Long ngGroupId) {
        this.ngGroupId = ngGroupId;
    }

    public String getSzMobile() {
        return szMobile;
    }

    public void setSzMobile(String szMobile) {
        this.szMobile = szMobile == null ? null : szMobile.trim();
    }

    public Integer getNtKind() {
        return ntKind;
    }

    public void setNtKind(Integer ntKind) {
        this.ntKind = ntKind;
    }

    public Integer getNtState() {
        return ntState;
    }

    public void setNtState(Integer ntState) {
        this.ntState = ntState;
    }

    public Integer getNtDevCount() {
        return ntDevCount;
    }

    public void setNtDevCount(Integer ntDevCount) {
        this.ntDevCount = ntDevCount;
    }

    public Integer getNtRowVersion() {
        return ntRowVersion;
    }

    public void setNtRowVersion(Integer ntRowVersion) {
        this.ntRowVersion = ntRowVersion;
    }

    public String getTxRemark() {
        return txRemark;
    }

    public void setTxRemark(String txRemark) {
        this.txRemark = txRemark == null ? null : txRemark.trim();
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "ngId=" + ngId +
                ", szUsername='" + szUsername + '\'' +
//                ", szPassword='" + szPassword + '\'' +
                ", szName='" + szName + '\'' +
                ", ngRegionId=" + ngRegionId +
                ", ngGroupId=" + ngGroupId +
                ", szMobile='" + szMobile + '\'' +
                ", ntKind=" + ntKind +
                ", ntState=" + ntState +
                ", ntDevCount=" + ntDevCount +
                ", ntRowVersion=" + ntRowVersion +
                ", txRemark='" + txRemark + '\'' +
                '}';
    }
}