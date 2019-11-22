package com.zz.springcloud.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zz.springcloud.user.dao.UserDao;
import com.zz.springcloud.user.service.UserService;
import com.zz.springcloud.userapi.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public PageInfo<User> showAll(int page,int pageSize) {
        PageHelper.startPage(page,pageSize);
        Example example = new Example(User.class);
        example.and().andNotEqualTo("status","-1");
        List<User> users = userDao.selectByExample(example);
        return new PageInfo(users,5);
    }

    @Override
    public PageInfo<User> showByFuzzy(int page,int pageSize,String fuzzy) {
        Example example = new Example(User.class);
        example.and()
                .andLike("userName","%"+fuzzy+"%")
                .orLike("address","%"+fuzzy+"%")
                .orLike("email","%"+fuzzy+"%")
                .orLike("telphone","%"+fuzzy+"%");
        PageHelper.startPage(page,pageSize);
        List<User> users = userDao.selectByExample(example);
        return new PageInfo(users,5);
    }

    @Override
    public Boolean update(User user) {
        int update = userDao.updateByPrimaryKeySelective(user);
        if (update==0){
            return false;
        }
        return true;
    }

    @Override
    public User showOne(User user) {
        return userDao.selectOne(user);
    }
}
