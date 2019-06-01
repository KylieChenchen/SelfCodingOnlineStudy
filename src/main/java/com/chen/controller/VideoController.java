package com.chen.controller;

import com.chen.common.JsonLayBean;
import com.chen.entity.video.Video;
import com.chen.service.VideoService;
import com.chen.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
public class VideoController {

    @Autowired
    private VideoService videoService;

    @RequestMapping("/course/videoupload.do")
    @ResponseBody
    public JsonLayBean upload(@RequestParam("file") MultipartFile upFile, HttpServletRequest request,Integer cid) {

        // 获取上传文件的文件名
        String fileName = upFile.getOriginalFilename();

        String path = request.getServletContext().getRealPath("/");
        System.out.println(path);
        File parentPath = new File(path);
        // 获取父级目录的路径
        path = parentPath.getParent() + "/webapp/ui/media/videos";

        System.out.println("path == " + path);
        File dirPath = new File(path);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
        //upfile.getInputStream()
        File file = new File(path, fileName);
        try {
            // 保存文件
            upFile.transferTo(file);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Video video = new Video();
        video.setCid(cid);
        video.setPreurl("media/videos/"+fileName);

        video.setCreatetime(new Date());
        videoService.insertVideo(video);
        return JsonUtils.createJsonBean(1, fileName, 0, path);
    }

    @RequestMapping("/video/add.do")
    @ResponseBody
    public JsonLayBean upload(@RequestParam("videourl") String videourl, Integer cid) {

        Video video = new Video();
        video.setCid(cid);
        video.setPreurl("media/videos/"+videourl);

        video.setCreatetime(new Date());
        videoService.insertVideo(video);
        return JsonUtils.createJsonBean(1, "", 0,"");
    }

}
