package com.chen.service.impl;


import com.chen.dao.LoginMapper;
import com.chen.entity.Admin;
import com.chen.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginDao;
    @Override
    public boolean login(String name, String password) {


        Admin auser = loginDao.findUserByName(name);
        if (auser == null){
            return false;
        }
        if (auser.getPassword().equals(password)){
            //登陆过后改变状态


//            userDao.updateByPrimaryKeySelective(auser);
            return true;
        }

        return false;
    }

}


















