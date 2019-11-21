package com.zz.springcloud.user;


import com.zz.springcloud.user.dao.UserDao;
import com.zz.springcloud.user.service.UserService;
import com.zz.springcloud.userapi.pojo.User;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationTests {

    @Autowired
    private UserService userService;


    @Autowired
    private UserDao userDao;

    @Test
    public void update() {
        User user = new User();
        user.setUserId(1);
        user.setPassword("111111");
        //Boolean update = userService.update(user);
        int i = userDao.updateByPrimaryKeySelective(user);
        log.info("--------------------"+i);
    }

    @Test
    public void showOne(){
        User user = new User();
//        user.setUserId(1);
        user.setUserName("李四");
        User selectOne = userDao.selectOne(user);
        log.info("--------------------------"+selectOne);
    }
}
