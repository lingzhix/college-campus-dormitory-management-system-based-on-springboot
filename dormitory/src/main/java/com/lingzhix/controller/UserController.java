package com.lingzhix.controller;

import com.github.pagehelper.PageInfo;
import com.lingzhix.entity.User;
import com.lingzhix.service.UserService;
import com.lingzhix.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author 596183363@qq.com
 * @Description:
 * @date 2020/11/1720:07
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("create")
    public Result create(@RequestBody User user){
        int flag = userService.create(user);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(String ids){
        int flag = userService.delete(ids);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }


    @PostMapping("update")
    public Result update(@RequestBody User user){
        int flag = userService.updateSelective(user);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("detail")
    public User detail(Integer id){
        return userService.detail(id);
    }

    @GetMapping("info")
    public Result info(HttpServletRequest request){
        User user = (User)request.getAttribute("user");
        return Result.ok(userService.detail(user.getId()));
    }


    @PostMapping("query")
    public Map<String,Object> query(@RequestBody User user){
        PageInfo<User> pageInfo = userService.query(user);
        return Result.ok(pageInfo);
    }

}
