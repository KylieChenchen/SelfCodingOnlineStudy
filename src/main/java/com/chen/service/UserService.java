package com.chen.service;


import com.chen.entity.user.User;
import com.chen.entity.user.UserDetail;

import java.util.List;

public interface UserService {


    public List<UserDetail> selectAllByPage(int page, int limit, String name, String sex, String flag);

    public void deleteUser(int id);


    public List<UserDetail> selectAll( String name, String sex,String flag);

    //更新
    public void update();

    public boolean login(String name,String password);


    public int add(User user);






}
