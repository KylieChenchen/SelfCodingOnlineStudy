package com.chen.service.impl;

import com.chen.dao.video.VideoMapper;
import com.chen.entity.video.Video;
import com.chen.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoDao;

    @Override
    public int insertVideo(Video video) {
        return videoDao.insertSelective(video);
    }
}
