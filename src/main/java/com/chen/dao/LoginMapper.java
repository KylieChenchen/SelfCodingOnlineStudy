package com.chen.dao;

import com.chen.entity.Admin;

public interface LoginMapper {

    //根据用户名找密码
    public Admin findUserByName(String name);
//    //找角色
//    public List<String> findRoleByName(String name);
//    //找权限
//    public List<String> findPermissionByName(String name);

}
