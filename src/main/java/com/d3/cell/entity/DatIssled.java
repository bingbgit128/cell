package com.d3.cell.entity;

import java.util.Date;

public class DatIssled {
    private Long ngId;

    private Long ngPacientId;

    private Long ngIndIssl;

    private Long ngIndPac;

    private Date dtDate;

    private Date tmTime;

    private String szNameIsl;

    private String szFname;

    private String szStoreFile;

    private Long ngIndOrg;

    private Double deNspin;

    private Double deSspin;

    private Double deNq;

    private Double deSq;

    private Integer ngPersonFree;

    private Integer ntTrimode;

    private Integer ntVegetoInd;

    private Integer ntMedicine;

    private Integer ntRowVersion;

    public Long getNgId() {
        return ngId;
    }

    public void setNgId(Long ngId) {
        this.ngId = ngId;
    }

    public Long getNgPacientId() {
        return ngPacientId;
    }

    public void setNgPacientId(Long ngPacientId) {
        this.ngPacientId = ngPacientId;
    }

    public Long getNgIndIssl() {
        return ngIndIssl;
    }

    public void setNgIndIssl(Long ngIndIssl) {
        this.ngIndIssl = ngIndIssl;
    }

    public Long getNgIndPac() {
        return ngIndPac;
    }

    public void setNgIndPac(Long ngIndPac) {
        this.ngIndPac = ngIndPac;
    }

    public Date getDtDate() {
        return dtDate;
    }

    public void setDtDate(Date dtDate) {
        this.dtDate = dtDate;
    }

    public Date getTmTime() {
        return tmTime;
    }

    public void setTmTime(Date tmTime) {
        this.tmTime = tmTime;
    }

    public String getSzNameIsl() {
        return szNameIsl;
    }

    public void setSzNameIsl(String szNameIsl) {
        this.szNameIsl = szNameIsl == null ? null : szNameIsl.trim();
    }

    public String getSzFname() {
        return szFname;
    }

    public void setSzFname(String szFname) {
        this.szFname = szFname == null ? null : szFname.trim();
    }

    public String getSzStoreFile() {
        return szStoreFile;
    }

    public void setSzStoreFile(String szStoreFile) {
        this.szStoreFile = szStoreFile == null ? null : szStoreFile.trim();
    }

    public Long getNgIndOrg() {
        return ngIndOrg;
    }

    public void setNgIndOrg(Long ngIndOrg) {
        this.ngIndOrg = ngIndOrg;
    }

    public Double getDeNspin() {
        return deNspin;
    }

    public void setDeNspin(Double deNspin) {
        this.deNspin = deNspin;
    }

    public Double getDeSspin() {
        return deSspin;
    }

    public void setDeSspin(Double deSspin) {
        this.deSspin = deSspin;
    }

    public Double getDeNq() {
        return deNq;
    }

    public void setDeNq(Double deNq) {
        this.deNq = deNq;
    }

    public Double getDeSq() {
        return deSq;
    }

    public void setDeSq(Double deSq) {
        this.deSq = deSq;
    }

    public Integer getNgPersonFree() {
        return ngPersonFree;
    }

    public void setNgPersonFree(Integer ngPersonFree) {
        this.ngPersonFree = ngPersonFree;
    }

    public Integer getNtTrimode() {
        return ntTrimode;
    }

    public void setNtTrimode(Integer ntTrimode) {
        this.ntTrimode = ntTrimode;
    }

    public Integer getNtVegetoInd() {
        return ntVegetoInd;
    }

    public void setNtVegetoInd(Integer ntVegetoInd) {
        this.ntVegetoInd = ntVegetoInd;
    }

    public Integer getNtMedicine() {
        return ntMedicine;
    }

    public void setNtMedicine(Integer ntMedicine) {
        this.ntMedicine = ntMedicine;
    }

    public Integer getNtRowVersion() {
        return ntRowVersion;
    }

    public void setNtRowVersion(Integer ntRowVersion) {
        this.ntRowVersion = ntRowVersion;
    }
}