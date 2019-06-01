package com.chen.entity.user;

import java.util.Date;

public class UserPromo {
    private Integer id;

    private Integer uid;

    private Integer beuid;

    private Integer coins;

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getBeuid() {
        return beuid;
    }

    public void setBeuid(Integer beuid) {
        this.beuid = beuid;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}