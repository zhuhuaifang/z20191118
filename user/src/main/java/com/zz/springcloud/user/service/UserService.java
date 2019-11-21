package com.zz.springcloud.user.service;

import com.github.pagehelper.PageInfo;
import com.zz.springcloud.userapi.pojo.User;

public interface UserService {
    PageInfo<User> showAll(int page,int pageSize);
    PageInfo<User> showByFuzzy(int page,int pageSize,String fuzzy);
    Boolean update(User user);
    User showOne(User user);
}
