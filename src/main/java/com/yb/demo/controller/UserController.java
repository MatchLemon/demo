package com.yb.demo.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yb.demo.dao.UserDao;
import com.yb.demo.model.User;
import com.yb.demo.service.UserService;
import com.yb.demo.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserDao userDao;
    @RequestMapping(value = "/getuser")
    @ResponseBody
    @ApiOperation(value = "获取用户信息", notes = "获取全部用户信息")
    public List<User> getUser() {
        List<User>  result = userService.list();
        return result;
    }

    @RequestMapping(value = "/saveuser")
    @ResponseBody
    @ApiOperation(value = "保存用户信息", notes = "获取全部用户信息")
    public Map getUser(User user) {
        boolean result = userService.save(user);
        Map<String, Object> map = new HashMap();
        map.put("code", 1);
        map.put("result", result);
        return map;
    }

    @RequestMapping(value = "/findById")
    @ResponseBody
    @ApiOperation(value = "保存用户信息", notes = "获取全部用户信息")
    public Map getUser1(User user) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", user.getId());
        user = userService.getOne(queryWrapper);
        Map<String, Object> map = new HashMap();
        map.put("code", 1);
        map.put("User", user);
        return map;
    }
}
