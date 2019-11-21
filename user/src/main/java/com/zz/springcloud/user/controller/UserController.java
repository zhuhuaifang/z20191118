package com.zz.springcloud.user.controller;

import com.github.pagehelper.PageInfo;
import com.zz.springcloud.user.service.UserService;
import com.zz.springcloud.userapi.pojo.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Log4j2
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/show")
    public ResponseEntity<PageInfo<User>> showAll(int page, int pageSize, @RequestParam(value = "fuzzy", required = false) String fuzzy) {
        PageInfo<User> users = null;
        if (fuzzy != null) {
            users = userService.showByFuzzy(page, pageSize, fuzzy);
        } else {
            users = userService.showAll(page, pageSize);
        }
        if (users == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/showOne")
    public ResponseEntity<User> showOne(@RequestBody User user){
        log.info("----------------------------"+user);
        User showOne = userService.showOne(user);
        if (showOne==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(showOne,HttpStatus.OK);
    }

    @RequestMapping(value = "/update")
    public ResponseEntity update(@RequestBody User user){
        Boolean update = userService.update(user);
        if (update){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
