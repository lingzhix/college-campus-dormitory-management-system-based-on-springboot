package com.lingzhix.controller;

import com.alibaba.fastjson.JSONObject;
import com.lingzhix.entity.Student;
import com.lingzhix.entity.User;
import com.lingzhix.framework.jwt.JWTUtil;
import com.lingzhix.service.LoginService;
import com.lingzhix.service.StudentService;
import com.lingzhix.service.UserService;
import com.lingzhix.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        if(user.getType() == null) return Result.fail("类型不能为空");
        if(user.getType() == 2){ //学生登录的
            Student entity = studentService.login(user.getUserName(),user.getPassword());
            if(entity != null){
                String token = JWTUtil.signForStudent(entity);
                Map map = new HashMap();
                map.put(JWTUtil.token,token);
                map.put("student",entity);
                return Result.ok("登陆成功",map);
            }else{
                return Result.fail("用户名或密码错误");
            }
        }else{//管理员与宿管员登录
            User entity = userService.login(user.getUserName(),user.getPassword());
            if(entity != null){
                String token = JWTUtil.sign(entity);
                Map map = new HashMap();
                map.put(JWTUtil.token,token);
                map.put("user",entity);
                return Result.ok("登陆成功",map);
            }else{
                return Result.fail("用户名或密码错误");
            }
        }
    }

    @PostMapping("/faceLogin")
    public Result faceLogin(@RequestBody JSONObject jsonObject) throws IOException {
        Map<String, Object> searchface = loginService.searchface(jsonObject.get("imagebast64").toString());
        if (searchface != null && searchface.get("user_id") != null) {
            // todo
            User user = userService.detail(1);
            String token = JWTUtil.sign(user);
            Map map = new HashMap();
            map.put(JWTUtil.token,token);
            map.put("user",user);
            return Result.ok("登陆成功",map);
        } else {
            return Result.ok("刷脸登录失败，正在重试");
        }
    }

}
