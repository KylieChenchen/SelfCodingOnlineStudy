package com.chen.service.impl;

import com.chen.dao.user.UserDetailMapper;
import com.chen.dao.user.UserMapper;
import com.chen.entity.user.User;
import com.chen.entity.user.UserDetail;
import com.chen.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private UserDetailMapper userDetailDao;

    @Autowired
    private UserMapper userDao;
    @Override
    public int insertUserDetail(UserDetail userDetail) {
        return userDetailDao.insertSelective(userDetail);
    }


    @Override
    public int insertUser(User user) {
        return userDao.insertSelective(user);
    }

    @Override
    public void addUserBatch(List<UserDetail> list) {
        int count = 1;
        List<UserDetail> tempList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){

            tempList.add(list.get(i));
            if(count % 100 != 0){
                count++;
            }else{
                userDetailDao.addBatch(tempList);
                tempList.clear();
                count = 1;
            }

        }
        if(tempList.size() != 0){
            userDetailDao.addBatch(tempList);
        }
    }

}
