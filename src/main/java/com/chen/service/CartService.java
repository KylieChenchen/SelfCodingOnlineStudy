package com.chen.service;

import com.chen.vo.CartVO;

import java.util.List;

public interface CartService {
    public List<CartVO> findAll(int uid);

    public int addCart(int uid,int cid);

    int delCart(int uid,int cid);
}
