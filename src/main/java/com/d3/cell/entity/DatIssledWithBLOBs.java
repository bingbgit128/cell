package com.d3.cell.entity;

public class DatIssledWithBLOBs extends DatIssled {
    private byte[] boGraph1;

    private byte[] boGraph2;

    private byte[] boData;

    private String txComment;

    public byte[] getBoGraph1() {
        return boGraph1;
    }

    public void setBoGraph1(byte[] boGraph1) {
        this.boGraph1 = boGraph1;
    }

    public byte[] getBoGraph2() {
        return boGraph2;
    }

    public void setBoGraph2(byte[] boGraph2) {
        this.boGraph2 = boGraph2;
    }

    public byte[] getBoData() {
        return boData;
    }

    public void setBoData(byte[] boData) {
        this.boData = boData;
    }

    public String getTxComment() {
        return txComment;
    }

    public void setTxComment(String txComment) {
        this.txComment = txComment == null ? null : txComment.trim();
    }
}