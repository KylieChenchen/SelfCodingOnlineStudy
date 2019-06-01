package com.chen.service.impl;

import com.chen.dao.LoginlogMapper;
import com.chen.entity.Loginlog;
import com.chen.service.LoginlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginlogServiceImpl implements LoginlogService {

    @Autowired
    private LoginlogMapper loginlogDao;

    @Override
    public List<Loginlog> findAll() {
        return loginlogDao.selectAll();
    }

    @Override
    public int addlog(Loginlog loginlog) {
        return loginlogDao.insertSelective(loginlog);
    }
}
