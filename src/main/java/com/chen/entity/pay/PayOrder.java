package com.chen.entity.pay;

import java.util.Date;

public class PayOrder {
    private Integer id;

    private Integer uid;

    private Integer uvid;

    private Integer type;

    private Integer money;

    private String preurl;

    private String info;

    private Short flag;

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

    public Integer getUvid() {
        return uvid;
    }

    public void setUvid(Integer uvid) {
        this.uvid = uvid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getPreurl() {
        return preurl;
    }

    public void setPreurl(String preurl) {
        this.preurl = preurl == null ? null : preurl.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Short getFlag() {
        return flag;
    }

    public void setFlag(Short flag) {
        this.flag = flag;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}