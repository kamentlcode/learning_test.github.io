package com.graduation.novelweb.dto;

import java.util.Date;

/**
 * 书评实体类
 * @author tanlin
 *
 */
public class Novels {
    private Integer nId;

    private String nName;

    private String nAuthor;

    private String nType;

    private Integer nWords;

    private String nIntro;

    private Integer nChapter;

    private Date createTime;

    private Date updateTime;

    private String nTest01;

    private String nTest02;

    private String nTest03;

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
        this.nName = nName;
    }

    public String getnAuthor() {
        return nAuthor;
    }

    public void setnAuthor(String nAuthor) {
        this.nAuthor = nAuthor;
    }

    public String getnType() {
        return nType;
    }

    public void setnType(String nType) {
        this.nType = nType;
    }

    public Integer getnWords() {
        return nWords;
    }

    public void setnWords(Integer nWords) {
        this.nWords = nWords;
    }

    public String getnIntro() {
        return nIntro;
    }

    public void setnIntro(String nIntro) {
        this.nIntro = nIntro;
    }

    public Integer getnChapter() {
        return nChapter;
    }

    public void setnChapter(Integer nChapter) {
        this.nChapter = nChapter;
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