package com.graduation.novelweb.dto;

import java.util.Date;

/**
 * 书评实体类
 * @author tanlin
 *
 */
public class Chapters {
    private Integer cId;

    private Integer nId;

    private String cName;

    private Integer cWords;

    private Date createTime;

    private Date updateTime;

    private String cTest01;

    private String cTest02;

    private String cTest03;

    private String cContent;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getnId() {
        return nId;
    }

    public void setnId(Integer nId) {
        this.nId = nId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Integer getcWords() {
        return cWords;
    }

    public void setcWords(Integer cWords) {
        this.cWords = cWords;
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

    public String getcTest01() {
        return cTest01;
    }

    public void setcTest01(String cTest01) {
        this.cTest01 = cTest01;
    }

    public String getcTest02() {
        return cTest02;
    }

    public void setcTest02(String cTest02) {
        this.cTest02 = cTest02;
    }

    public String getcTest03() {
        return cTest03;
    }

    public void setcTest03(String cTest03) {
        this.cTest03 = cTest03;
    }

    public String getcContent() {
        return cContent;
    }

    public void setcContent(String cContent) {
        this.cContent = cContent;
    }
}