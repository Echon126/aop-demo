package com.wen.aop.example.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * @author admin
 * @date 2018-11-27 9:58
 */
public class ResponseData implements Serializable {
    private String status;
    private Long len;
    private byte[] content;
    private String dec;
    private Date date;

    public ResponseData(String status, String dec, Date date) {
        this.status = status;
        this.dec = dec;
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getLen() {
        return len;
    }

    public void setLen(Long len) {
        this.len = len;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "status='" + status + '\'' +
                ", len=" + len +
                ", content=" + Arrays.toString(content) +
                ", dec='" + dec + '\'' +
                ", date=" + date +
                '}';
    }
}
