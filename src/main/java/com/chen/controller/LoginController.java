package com.chen.controller;


import com.chen.common.JsonBean;
import com.chen.common.JsonIp;
import com.chen.entity.Loginlog;
import com.chen.service.LoginService;
import com.chen.service.LoginlogService;
import com.chen.utils.IpUtils;
import com.chen.utils.JsonUtils;
import com.chen.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@RestController
public class LoginController {

    @Autowired
    private LoginlogService loginlogService;
    @Autowired
    private LoginService loginService;
    @RequestMapping("/login.do")
    public JsonBean login(String name, String password,String ip){
        JsonIp info = null;
        String location = null;
        IpUtils ipUtils = new IpUtils();
        Loginlog loginlog = new Loginlog();
        Date date = new Date();
        String mdPassword = MD5Utils.md5(password);
        try {
            boolean flag = loginService.login(name, mdPassword);
            if (flag) {
                try {
                    info = ipUtils.getAddresses("ip=" + ip, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (info.getCode() == 0) {
                    String city = info.getData().getCity();
                    String region = info.getData().getRegion();
                    location = region + "省" + city + "市";
                    loginlog.setCreatetime(date);
                    loginlog.setIp(ip);
                    System.out.println(ip);
                    loginlog.setLocation(location);
                    loginlog.setNo(name);
                    loginlogService.addlog(loginlog);
                } else if (info.getCode() == 1) {
                    location = "内网访问";
                } else {
                    location = "访问错误";
                }
                return  JsonUtils.createJsonBean(1,"登录成功");
            }
            return JsonUtils.createJsonBean(0,"用户不存在或密码错误");
//            session.setAttribute("user",user);
        } catch (Exception e) {
            e.printStackTrace();
            return  JsonUtils.createJsonBean(0,e.getMessage());
        }
    }
}











