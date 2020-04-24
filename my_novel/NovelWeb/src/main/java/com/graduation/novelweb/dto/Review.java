package com.graduation.novelweb.dto;

import java.util.Date;

public class Review {
    private Integer rId;

    private Integer nId;

    private Integer uId;

    private Date createTime;

    private Date updateTime;

    private String rTest01;

    private String rTest02;

    private String rTest03;

    private String rContent;

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Integer getnId() {
        return nId;
    }

    public void setnId(Integer nId) {
        this.nId = nId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getrTest01() {
        return rTest01;
    }

    public void setrTest01(String rTest01) {
        this.rTest01 = rTest01 == null ? null : rTest01.trim();
    }

    public String getrTest02() {
        return rTest02;
    }

    public void setrTest02(String rTest02) {
        this.rTest02 = rTest02 == null ? null : rTest02.trim();
    }

    public String getrTest03() {
        return rTest03;
    }

    public void setrTest03(String rTest03) {
        this.rTest03 = rTest03 == null ? null : rTest03.trim();
    }

    public String getrContent() {
        return rContent;
    }

    public void setrContent(String rContent) {
        this.rContent = rContent == null ? null : rContent.trim();
    }
}