package com.chen.controller;

import com.chen.common.JsonLayBean;
import com.chen.dao.course.CourseMapper;
import com.chen.entity.course.Course;
import com.chen.service.CourseService;
import com.chen.utils.JsonUtils;
import com.chen.vo.CourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseMapper courseDao;

    @RequestMapping("course/listAll.do")
    @ResponseBody
    public JsonLayBean listInfo(){

        List<CourseVO> list = courseService.listInfo();
        return JsonUtils.createJsonBean(1,"",list.size(),list);

    }


    // 后台的
    @RequestMapping("course/list.do")
    @ResponseBody
    public JsonLayBean list(int page, int limit){

        List<CourseVO> list = courseService.findAllCourse((page-1)*limit,limit);
        List<CourseVO> list1 = courseService.listInfo();
        return JsonUtils.createJsonBean(0,"",list1.size(),list);
    }

    @RequestMapping("course/listbytype.do")
    @ResponseBody
    public JsonLayBean listByCondition(@RequestParam("tid") int tid,@RequestParam("min") int min,@RequestParam("max") int max){

//        if (tid == 0){
//            tid= Integer.parseInt(null);
//        }
        List<CourseVO> list = courseService.listByCondition(tid, min, max);
        return JsonUtils.createJsonBean(1,"",list.size(),list);

    }

    @RequestMapping("course/update.do")
    @ResponseBody
    public JsonLayBean update(@RequestParam("id") int id,@RequestParam("name") String name,@RequestParam("tid") int tid,@RequestParam("aid") int aid,@RequestParam("coins") int coins){

        Course course = courseDao.selectByPrimaryKey(id);
        course.setAid(aid);
        course.setCoins(coins);
        course.setTid(tid);
        course.setName(name);

        int i = courseService.update(course);
        return JsonUtils.createJsonBean(1,"",i,"修改成功");

    }

    @RequestMapping("course/add.do")
    @ResponseBody
    public JsonLayBean add(@RequestParam("name") String name,@RequestParam("tid") int tid,@RequestParam("aid") int aid,@RequestParam("coins") int coins,@RequestParam("photo") String photo){

        Course course = new Course();
        course.setAid(aid);
        course.setCoins(coins);
        course.setTid(tid);
        course.setName(name);
        course.setInfo("media/images/"+photo);

        int i = courseService.add(course);
        return JsonUtils.createJsonBean(1,"",i,"添加成功");

    }

    @RequestMapping("course/delete.do")
    @ResponseBody
    public JsonLayBean delete(@RequestParam("id") int id){


        int i = courseService.deleteById(id);
        return JsonUtils.createJsonBean(1,"",i,"删除成功");

    }


    @RequestMapping("/course/photoupload.do")
    @ResponseBody
    public JsonLayBean upload(@RequestParam("file") MultipartFile upFile, HttpServletRequest request) {

        // 获取上传文件的文件名
        String fileName = upFile.getOriginalFilename();

        String path = request.getServletContext().getRealPath("/");
        System.out.println(path);
        File parentPath = new File(path);
        // 获取父级目录的路径
        path = parentPath.getParent() + "/webapp/ui/media/images";

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

        return JsonUtils.createJsonBean(1, fileName, 0, path);
    }
}
