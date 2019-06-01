package com.chen.service;

import com.chen.entity.user.User;
import com.chen.entity.user.UserDetail;

import java.util.List;

public interface StudentService {

    int insertUserDetail(UserDetail userDetail);

    int insertUser(User user);

    public void addUserBatch(List<UserDetail> list);

}
