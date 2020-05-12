package com.d3.cell.entity;

public class DatPacientWithBLOBs extends DatPacient {
    private String txComment;

    private String txEpicrisis;

    private byte[] boSample;

    private byte[] boLearn;

    public String getTxComment() {
        return txComment;
    }

    public void setTxComment(String txComment) {
        this.txComment = txComment == null ? null : txComment.trim();
    }

    public String getTxEpicrisis() {
        return txEpicrisis;
    }

    public void setTxEpicrisis(String txEpicrisis) {
        this.txEpicrisis = txEpicrisis == null ? null : txEpicrisis.trim();
    }

    public byte[] getBoSample() {
        return boSample;
    }

    public void setBoSample(byte[] boSample) {
        this.boSample = boSample;
    }

    public byte[] getBoLearn() {
        return boLearn;
    }

    public void setBoLearn(byte[] boLearn) {
        this.boLearn = boLearn;
    }
}