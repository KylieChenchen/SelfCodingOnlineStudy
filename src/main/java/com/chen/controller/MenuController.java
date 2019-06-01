package com.chen.controller;

import com.chen.common.JsonLayBean;
import com.chen.service.MenuService;
import com.chen.utils.JsonUtils;
import com.chen.vo.VMenuInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/menu/findAll.do")
    public JsonLayBean findMenu() {
        List<VMenuInfo> menu = menuService.findMenu();
        return JsonUtils.createJsonBean(0,"", 20, menu);
    }

}
