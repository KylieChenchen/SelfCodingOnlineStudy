package com.chen.entity.pay;

import java.util.Date;

public class PayInfo {
    private Integer id;

    private String ercodeurl;

    private Integer type;

    private Integer uvid;

    private Integer money;

    private String ip;

    private Short flag;

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getErcodeurl() {
        return ercodeurl;
    }

    public void setErcodeurl(String ercodeurl) {
        this.ercodeurl = ercodeurl == null ? null : ercodeurl.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getUvid() {
        return uvid;
    }

    public void setUvid(Integer uvid) {
        this.uvid = uvid;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
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