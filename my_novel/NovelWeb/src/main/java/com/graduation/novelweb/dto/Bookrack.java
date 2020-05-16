package com.graduation.novelweb.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 书架实体类
 */
public class Bookrack implements Serializable {
    private static final long serialVersionUID = 1161694292001161694L;
    /**
     * 书架id
     */
    private Integer bId;
    /**
     *用户id
     */
    private Integer uId;
    /**
     *书架名称
     */
    private String bName;

    /**
     * 书架小说关联集合
     */
    private List<Novels> brNovels;

    public List<Novels> getBrNovels() {
        return brNovels;
    }

    public void setBrNovels(List<Novels> brNovels) {
        this.brNovels = brNovels;
    }

    /**
     *
     */
    private Date createTime;
    /**
     *
     */
    private Date updateTime;

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName == null ? null : bName.trim();
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
}