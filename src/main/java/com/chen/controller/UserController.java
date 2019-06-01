package com.chen.controller;

import com.chen.common.JsonBean;
import com.chen.common.JsonLayBean;
import com.chen.dao.user.UserMapper;
import com.chen.entity.user.User;
import com.chen.entity.user.UserDetail;
import com.chen.service.UserService;
import com.chen.utils.JsonUtils;
import com.chen.utils.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userDao;

    @RequestMapping("/userloginout.do")
    public JsonBean logout(){
        userService.update();
        return  JsonUtils.createJsonBean(1,null);
    }

    @RequestMapping("/user/findInfo.do")
    public JsonBean indInfo(){
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return  JsonUtils.createJsonBean(0,user);
    }

    @RequestMapping("/user/userall.do")
    public JsonLayBean listAll(int page, int limit, String name, String flag,String sex){
//        int f = Integer.parseInt(flag);
        List<UserDetail> list = userService.selectAllByPage((page-1)*limit,limit,name,sex,flag);
        List<UserDetail> list1 = userService.selectAll(name, sex, flag);

        return JsonUtils.createJsonBean(0,"",list1.size(),list);
    }

    @RequestMapping("/user/delete.do")
    public JsonLayBean delete(int id){
        userService.deleteUser(id);
        return JsonUtils.createJsonBean(1,"",0,null);
    }

    @RequestMapping("/user/login.do")
    public JsonLayBean login(String no, String password, HttpServletRequest request){

        String mdPassword = MD5Utils.md5(password);
        boolean flag = userService.login(no, mdPassword);

        HttpSession session = request.getSession();
        if (flag){
            UserDetail user = userDao.findByName(no);

            session.setAttribute("user", user);

            return JsonUtils.createJsonBean(1,"",0,null);
        }
        return JsonUtils.createJsonBean(0,"",0,null);
    }

    @RequestMapping("/user/register.do")
    public JsonLayBean register(String no,String password){

        String mdPassword = MD5Utils.md5(password);
        User user = new User();
        user.setNo(no);
        user.setPassword(mdPassword);
        user.setFlag(0);
        int i = userService.add(user);
        return JsonUtils.createJsonBean(1,"",0,i);
//        return JsonUtils.createJsonBean(0,"",0,null);

    }


}
