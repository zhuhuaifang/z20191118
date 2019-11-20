package com.zz.springcloud.user.controller;

import com.github.pagehelper.PageInfo;
import com.zz.springcloud.user.service.UserService;
import com.zz.springcloud.userapi.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public PageInfo<Users> showAll(){

        return userService.showAll();
    }
}
