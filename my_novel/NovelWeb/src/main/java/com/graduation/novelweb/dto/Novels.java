package com.graduation.novelweb.dto;

import java.util.Date;

public class Novels {

    /**
     * id
     */
    private Integer nId;

    /**
     * 名称
     */
    private String nName;

    /**
     * 作者
     */
    private String nAuthor;

    private enum Type{
        玄幻,
        仙侠,
        都市,
        历史,
        科幻,
    }
    /**
     * 类型
     */
    private Type nType;

    /**
     * 简介
     */
    private String nIntro;

    private Integer count;

    private Date createTime;

    private Date updateTime;

    private String nTest01;

    private String nTest02;

    private String nTest03;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getnId() {
        return nId;
    }

    public void setnId(Integer nId) {
        this.nId = nId;
    }

    public String getnName() {
        return nName;
    }

    public void setnName(String nName) {
        this.nName = nName == null ? null : nName.trim();
    }

    public String getnAuthor() {
        return nAuthor;
    }

    public void setnAuthor(String nAuthor) {
        this.nAuthor = nAuthor;
    }

    public Type getnType() {
        return nType;
    }

    public void setnType(Type nType) {
        this.nType = nType;
    }

    public String getnIntro() {
        return nIntro;
    }

    public void setnIntro(String nIntro) {
        this.nIntro = nIntro;
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

    public String getnTest01() {
        return nTest01;
    }

    public void setnTest01(String nTest01) {
        this.nTest01 = nTest01;
    }

    public String getnTest02() {
        return nTest02;
    }

    public void setnTest02(String nTest02) {
        this.nTest02 = nTest02;
    }

    public String getnTest03() {
        return nTest03;
    }

    public void setnTest03(String nTest03) {
        this.nTest03 = nTest03;
    }
}