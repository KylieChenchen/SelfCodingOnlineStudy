package com.chen.dao.user;


import com.chen.entity.user.User;
import com.chen.entity.user.UserDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    public List<UserDetail> selectConditionByPage(@Param("page") int page, @Param("limit") int limit, @Param("name") String name, @Param("sex") String sex, @Param("flag") String flag);


    public List<UserDetail> selectConditionAll(@Param("name") String name, @Param("sex") String sex, @Param("flag") String flag);

    public User findByNo(String no);

    public UserDetail findByName(String name);

//    public int insertUser(UserDetail userDetail);
}