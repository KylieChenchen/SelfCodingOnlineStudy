package com.chen.service.impl;

import com.chen.dao.cart.CartMapper;
import com.chen.service.CartService;
import com.chen.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartDao;

    @Override
    public List<CartVO> findAll(int uid) {
        return cartDao.selectAll(uid);
    }

    @Override
    public int addCart(int uid, int cid) {
        return cartDao.addCart(uid, cid);
    }

    @Override
    public int delCart(int uid, int cid) {
        return cartDao.delCart(uid,cid);
    }
}
