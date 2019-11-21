package com.zz.springcloud.admin.controller;

import com.github.pagehelper.PageInfo;
import com.zz.springcloud.userapi.pojo.User;
import com.zz.springcloud.userapi.api.UserApi;
import com.zz.springcloud.userapi.pojo.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Log4j2
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserApi userApi;


    //@CrossOrigin
    @RequestMapping("/show")
    public ResponseEntity<PageInfo<User>> showAll(@RequestParam(value = "page",defaultValue = "1") int page, @RequestParam(value = "pageSize",defaultValue = "5") int pageSize, @RequestParam(value = "fuzzy",required = false)String fuzzy){
        //response.setHeader("Access-Control-Allow-Origin", "*");
        //response.setHeader("C ache-Control","no-cache");
        log.info(userApi.showAll(page,pageSize,fuzzy));
        return userApi.showAll(page,pageSize,fuzzy);
    }

    @RequestMapping(value = "/showOne")
    public ResponseEntity<User> showOne(@RequestParam("userId") Integer userId){
        log.info("--------------"+userId);
        User user = new User();
        user.setUserId(userId);
        log.info("========================"+userApi.showOne(user));
        return userApi.showOne(user);
    }

    @RequestMapping("/update")
    public ResponseEntity update(User user){
        return userApi.update(user);
    }

}
