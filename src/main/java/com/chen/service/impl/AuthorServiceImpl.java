package com.chen.service.impl;

import com.chen.dao.course.AuthorMapper;
import com.chen.entity.course.Author;
import com.chen.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorMapper authorDao;
    @Override
    public List<Author> findAll() {
        return authorDao.findAll();
    }

    @Override
    public int deleteById(int id) {
        return authorDao.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Author author) {
        return authorDao.updateByPrimaryKeySelective(author);
    }

    @Override
    public String getLastId() {
        return authorDao.getLastId();
    }

    @Override
    public int add(Author author) {
        return authorDao.insertSelective(author);
    }
}
