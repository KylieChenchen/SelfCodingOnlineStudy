package com.chen.entity.user;

import java.util.Date;

public class AwardLog {
    private Long id;

    private Integer uwid;

    private Integer coins;

    private Date startdate;

    private Date enddate;

    private Short validity;

    private Short type;

    private Date createtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUwid() {
        return uwid;
    }

    public void setUwid(Integer uwid) {
        this.uwid = uwid;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Short getValidity() {
        return validity;
    }

    public void setValidity(Short validity) {
        this.validity = validity;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}