package com.zz.springcloud.admin.controller;

import com.github.pagehelper.PageInfo;
import com.zz.springcloud.userapi.api.UserApi;
import com.zz.springcloud.userapi.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


@RestController
public class AdminController {

    @Autowired
    private UserApi userApi;

    //@CrossOrigin
    @RequestMapping("/show")
    public PageInfo<Users> showAll(HttpServletResponse response){
        //response.setHeader("Access-Control-Allow-Origin", "*");
        //response.setHeader("Cache-Control","no-cache");
        return userApi.showAll();
    }
}
