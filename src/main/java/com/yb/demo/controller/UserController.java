package com.yb.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yb.demo.dao.UserDao;
import com.yb.demo.model.User;
import com.yb.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        System.out.println("============2222222============");
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

    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "保存用户信息", notes = "获取全部用户信息")
    public Map getUser1(@RequestBody User user) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", user.getId());
        user = userService.getOne(queryWrapper);
        Map<String, Object> map = new HashMap();
        map.put("code", 1);
        map.put("User", user);
        return map;
    }

    @RequestMapping(value = "/findBypage")
    @ResponseBody
    @ApiOperation(value = "分页", notes = "分页用户")
    public Map findBypage(Integer current, Integer pageSize) {
        QueryWrapper queryWrapper = new QueryWrapper();
        //queryWrapper.eq("id", user.getId());
        Page<User> page  = new Page();
        page.setCurrent(current);
        //page.setPages(pageSize);
        page.setSize(pageSize);
        IPage<User>  pages = userService.page(page);
        Map<String, Object> map = new HashMap();
        map.put("code", 1);
        map.put("User", pages);
        return map;
    }

}
