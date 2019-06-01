package com.chen.controller;

import com.chen.common.JsonBean;
import com.chen.entity.user.UserDetail;
import com.chen.service.CartService;
import com.chen.utils.JsonUtils;
import com.chen.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping("cart/list.do")
    @ResponseBody
    public JsonBean listByUid(HttpServletRequest request){
        HttpSession session = request.getSession();
        UserDetail user = (UserDetail) session.getAttribute("user");
        System.out.println(user.getName());
        List<CartVO> list = cartService.findAll(user.getId());
        return JsonUtils.createJsonBean(1,list);
    }


    @RequestMapping("cart/add.do")
    public String addCart(int cid,HttpServletRequest request){

        HttpSession session = request.getSession();
        UserDetail user = (UserDetail) session.getAttribute("user");
        System.out.println(user.getName());
        cartService.addCart(user.getId(),cid);
        return "redirect:/ui/cart.html";
    }

    @RequestMapping("cart/del.do")
    @ResponseBody
    public JsonBean delCart(int cid, HttpServletRequest request){

        HttpSession session = request.getSession();
        UserDetail user = (UserDetail) session.getAttribute("user");
        System.out.println(user.getName());
        cartService.delCart(user.getId(),cid);
        return JsonUtils.createJsonBean(1,"删除成功");
    }
}
