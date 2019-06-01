package com.chen.controller;

import com.chen.common.JsonBean;
import com.chen.entity.user.UserDetail;
import com.chen.service.StudentService;
import com.chen.utils.ImportExcel;
import com.chen.utils.JsonUtils;
import com.chen.utils.MD5Utils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping("/student/add.do")
    public String addStudent(String id, String name, String sex, String phone, String cardno, String education, Date birthday,String email){
        UserDetail userDetail = new UserDetail();
        userDetail.setName(name);
        userDetail.setCardno(cardno);
        userDetail.setBirthday(birthday);
        userDetail.setPhone(phone);
        userDetail.setEducation(education);
        int s = 1;
        if (sex.equals("女")){
            s = 0;
        }
        userDetail.setFlag(0);
        userDetail.setEmail(email);
        userDetail.setSex(s);
        userDetail.setPassword(MD5Utils.md5("123"));
        studentService.insertUserDetail(userDetail);

//        User user = new User();
//        user.setNo(no);
//        user.setFlag(0);
//        user.setPassword(MD5Utils.md5("123"));
//        studentService.insertUser(user);
        return "redirect:/back/sc_student/studentlist.html";
    }



    @RequestMapping("/student/import.do")
    @ResponseBody
    public JsonBean importExcel(@RequestParam MultipartFile mFile){
            try {
                String fileName = mFile.getOriginalFilename();
                // 获取上传文件的输入流
                InputStream inputStream = mFile.getInputStream();
                // 调用工具类中方法，读取excel文件中数据
                List<Map<String, Object>> sourceList = ImportExcel.readExcel(fileName, inputStream);

                // 将对象先转为json格式字符串，然后再转为List<SysUser> 对象
                ObjectMapper objMapper = new ObjectMapper();
                String infos = objMapper.writeValueAsString(sourceList);

                // json字符串转对象
                List<UserDetail> list = objMapper.readValue(infos, new TypeReference<List<UserDetail>>() {});

                // 批量添加
                studentService.addUserBatch(list);

                return JsonUtils.createJsonBean(1, null);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

                return JsonUtils.createJsonBean(0, e.getMessage());
            }

    }



}
