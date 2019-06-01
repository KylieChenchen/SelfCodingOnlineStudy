package com.chen.service.impl;


import com.chen.dao.user.UserDetailMapper;
import com.chen.dao.user.UserMapper;
import com.chen.entity.user.User;
import com.chen.entity.user.UserDetail;
import com.chen.service.UserService;
import com.chen.utils.SessionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userDao;

    @Autowired
    private UserDetailMapper userDetailDao;


    @Override
    public List<UserDetail> selectAllByPage(int page, int limit, java.lang.String name, java.lang.String sex, java.lang.String flag) {
        List<UserDetail> list = userDao.selectConditionByPage(page, limit, name, sex, flag);
        return list;
    }

    @Override
    public void deleteUser(int id) {

//        userDao.deleteByPrimaryKey(id);
        userDetailDao.deleteByPrimaryKey(id);
    }

    @Override
    public List<UserDetail> selectAll(String name, String sex, String flag) {
        return userDao.selectConditionAll(name, sex, flag);
    }


    @Override
    public void update() {
        Session session =  SessionUtils.getSession();
        User user = (User) session.getAttribute(SessionUtils.LONG_USER);
        Subject subject = SecurityUtils.getSubject();
        user.setFlag(1);
        subject.logout();
        userDao.updateByPrimaryKeySelective(user);

    }

    @Override
    public boolean login(String name, String password) {

        UserDetail user = userDao.findByName(name);
        if (user.getPassword().equals(password)){

            return true;
        }
        return false;
    }

    @Override
    public int add(User user) {
        return userDao.insert(user);
    }


}


