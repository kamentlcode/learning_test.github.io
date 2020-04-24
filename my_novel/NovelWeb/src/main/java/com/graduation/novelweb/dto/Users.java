package com.graduation.novelweb.dto;

import java.util.Date;

public class Users {
    private Integer uId;

    private String uNickname;

    private String uName;

    private String uPassword;

    private Integer uPermission;

    private Date createTime;

    private Date updateTime;

    private String uTest01;

    private String uTest02;

    private String uTest03;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuNickname() {
        return uNickname;
    }

    public void setuNickname(String uNickname) {
        this.uNickname = uNickname == null ? null : uNickname.trim();
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword == null ? null : uPassword.trim();
    }

    public Integer getuPermission() {
        return uPermission;
    }

    public void setuPermission(Integer uPermission) {
        this.uPermission = uPermission;
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

    public String getuTest01() {
        return uTest01;
    }

    public void setuTest01(String uTest01) {
        this.uTest01 = uTest01 == null ? null : uTest01.trim();
    }

    public String getuTest02() {
        return uTest02;
    }

    public void setuTest02(String uTest02) {
        this.uTest02 = uTest02 == null ? null : uTest02.trim();
    }

    public String getuTest03() {
        return uTest03;
    }

    public void setuTest03(String uTest03) {
        this.uTest03 = uTest03 == null ? null : uTest03.trim();
    }
}