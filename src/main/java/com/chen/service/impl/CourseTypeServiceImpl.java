package com.chen.service.impl;

import com.chen.dao.course.CourseTypeMapper;
import com.chen.entity.course.CourseType;
import com.chen.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseTypeServiceImpl implements CourseTypeService {

    @Autowired
    private CourseTypeMapper typeDao;
    @Override
    public List<CourseType> selectAll() {
        return typeDao.findAll();
    }
}
