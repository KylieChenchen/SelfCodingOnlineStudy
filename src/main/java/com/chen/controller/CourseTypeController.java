package com.chen.controller;

import com.chen.common.JsonLayBean;
import com.chen.entity.course.CourseType;
import com.chen.service.CourseTypeService;
import com.chen.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseTypeController {

    @Autowired
    private CourseTypeService typeService;

    @RequestMapping("ctype/listAll.do")
    public JsonLayBean listType(){

        List<CourseType> list = typeService.selectAll();
        return JsonUtils.createJsonBean(1,"",list.size(),list);
    }
}
