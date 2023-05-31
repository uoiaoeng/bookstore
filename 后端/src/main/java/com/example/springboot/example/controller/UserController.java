package com.example.springboot.example.controller;

import com.example.springboot.example.service.UserService;
import com.example.springboot.example.entity.User;
import com.example.springboot.example.utils.JwtUtil;
import com.example.springboot.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description: TODO
 * @Author linjiangyi
 * @Date 8/30/22
 * @Version V1.0
 **/
//@Component
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping(method = RequestMethod.POST,value = "/trans")
    public Result trans(String fromId,String toId,Double money){
        Result result = new Result();
        try {
            Boolean blFlag = userService.trans(fromId,toId,money);
            if(blFlag){
                result.success("转账成功");
            }else {
                result.fail("转账失败");
            }
        }catch (Exception e){
            result.fail(e.toString());
        }

        return result;
    }

    //用户登录
    @RequestMapping(method = RequestMethod.POST,value = "/login")
    public Result login(@RequestBody User user){
        Result result = new Result();
        User userExit = userService.getByName(user.getUsername());

        if(userExit == null) {
            result.fail("用户名错误");
            return result;
        }else{
            User loginUser = userService.getByName(user.getUsername());
            if(!user.getPassword().equals(loginUser.getPassword())){
                result.fail("密码错误");
                return result;
            }
        }

        Map<String,Object> map = new HashMap<>();
        map.put("user",user);
        map.put("token", JwtUtil.generateToken(user.getId()));
        result.success("登录成功");
        result.setData(map);
        return result;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/validate")
    public Result getByUsername(String username){
        Result result = new Result();
        User userExit = userService.getByName(username);
        result.setData(userExit);
        if(userExit!=null){
            result.success("用户名存在");
        }else{
            result.success("用户名不存在");
        }
        return result;
    }


    //用户注册
    @RequestMapping(method = RequestMethod.POST,value = "/register")
    public Result register(@RequestBody User user){
        Result result = new Result();

        User userExit = userService.getByName(user.getUsername());
        if(userExit != null){
            //用户名已存在
            result.fail("用户名:" + user.getUsername() + "已存在");
        }else {
            userService.add(user);
            result.success("注册成功");
        }
        return result;
    }

    //注销账号
    @RequestMapping(method = RequestMethod.POST,value = "/cancel")
    public Result cancel(@RequestBody User user){
        Result result = new Result();
        User userExit = userService.getByName(user.getUsername());
        userService.deleteByIds(userExit.getId());
        result.success("删除成功");
        return result;
    }


    //更新
    @RequestMapping(method = RequestMethod.POST,value = "/update")
    public Result update(@RequestBody User user){
        Result result = new Result();

        userService.update(user);
        result.success("更新成功");
        return result;
    }

    //更新收藏
    @RequestMapping(method = RequestMethod.POST,value = "/updateColl")
    public Result updateColl(String username,String bookId,Boolean flag){
        Result result = new Result();
        User userExit = userService.getByName(username);
        userService.updateColle(userExit,bookId,flag);
        result.success("更新成功");
        return result;
    }


}
