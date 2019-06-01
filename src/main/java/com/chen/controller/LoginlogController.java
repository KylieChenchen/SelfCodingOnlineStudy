package com.chen.controller;

import com.chen.common.JsonLayBean;
import com.chen.entity.Loginlog;
import com.chen.service.LoginlogService;
import com.chen.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/loginlog")
public class LoginlogController {
    @Autowired
    private LoginlogService loginlogService;

    @RequestMapping("/findAll.do")
    public JsonLayBean findAll(){
        List<Loginlog> list = loginlogService.findAll();
        return JsonUtils.createJsonBean(0,"",20, list);
    }
}
