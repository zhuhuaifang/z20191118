package com.zz.springcloud.user.service;

import com.github.pagehelper.PageInfo;
import com.zz.springcloud.userapi.pojo.Users;

import java.util.List;

public interface UserService {
    public PageInfo<Users> showAll();
}
