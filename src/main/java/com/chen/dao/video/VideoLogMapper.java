package com.chen.dao.video;


import com.chen.entity.video.VideoLog;

public interface VideoLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VideoLog record);

    int insertSelective(VideoLog record);

    VideoLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VideoLog record);

    int updateByPrimaryKey(VideoLog record);
}