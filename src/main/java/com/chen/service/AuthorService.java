package com.chen.service;

import com.chen.entity.course.Author;

import java.util.List;

public interface AuthorService {

    public List<Author> findAll();

    int deleteById(int id);

    int update(Author author);

    String getLastId();

    int add(Author author);
}
