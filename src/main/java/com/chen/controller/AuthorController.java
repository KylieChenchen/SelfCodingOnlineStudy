package com.chen.controller;

import com.chen.common.JsonLayBean;
import com.chen.entity.course.Author;
import com.chen.service.AuthorService;
import com.chen.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @RequestMapping("author/list.do")
    @ResponseBody
    public JsonLayBean listInfo(){

        List<Author> list = authorService.findAll();
        return JsonUtils.createJsonBean(0,"",list.size(),list);

    }

    @RequestMapping("author/del.do")
    @ResponseBody
    public JsonLayBean delete(int id){
        int i = authorService.deleteById(id);
        return JsonUtils.createJsonBean(1,"",i,"删除成功");
    }


    @RequestMapping("author/update.do")
    @ResponseBody
    public JsonLayBean update(Author author){
        int i = authorService.update(author);
        return JsonUtils.createJsonBean(1,"",i,"");
    }

    @RequestMapping("author/getid.do")
    @ResponseBody
    public JsonLayBean getId(){
        String str = authorService.getLastId();
        int i= Integer.parseInt(str);
        i++;
        return JsonUtils.createJsonBean(1,i+"",1,i);
    }

    @RequestMapping("author/add.do")
    public String add(Author author){
        int i = authorService.add(author);
        return "redirect:/back/sc_author/authorlist.html";
    }

}
