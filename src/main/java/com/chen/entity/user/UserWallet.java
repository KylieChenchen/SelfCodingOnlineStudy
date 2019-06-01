package com.chen.entity.user;

public class UserWallet {
    private Integer id;

    private Integer coins;

    private Integer redcoins;

    private Integer losecoins;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public Integer getRedcoins() {
        return redcoins;
    }

    public void setRedcoins(Integer redcoins) {
        this.redcoins = redcoins;
    }

    public Integer getLosecoins() {
        return losecoins;
    }

    public void setLosecoins(Integer losecoins) {
        this.losecoins = losecoins;
    }
}