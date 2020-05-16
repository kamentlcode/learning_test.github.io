package com.graduation.novelweb.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 书架小说关联
 */
public class BoorackNovelRel implements Serializable {

    private static final long serialVersionUID = 4371742920901161694L;
    /**
     * 关联id
     */
    private Integer relId;
    /**
     * 书架id
     */
    private Integer bId;
    /**
     * 小说id
     */
    private Integer nId;
    /**
     * 用户id
     */
    private Integer uId;

    private Date createTime;

    private Date updateTime;

    public Integer getRelId() {
        return relId;
    }

    public void setRelId(Integer relId) {
        this.relId = relId;
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
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
}