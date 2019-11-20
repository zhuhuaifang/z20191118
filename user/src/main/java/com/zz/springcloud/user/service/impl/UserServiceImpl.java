package com.zz.springcloud.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zz.springcloud.user.dao.UserDao;
import com.zz.springcloud.user.service.UserService;
import com.zz.springcloud.userapi.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public PageInfo<Users> showAll() {
        PageHelper.startPage(1,2);
        List<Users> usersList = userDao.selectAll();
        PageInfo<Users> pageInfo = new PageInfo(usersList);
        return pageInfo;
    }
}
