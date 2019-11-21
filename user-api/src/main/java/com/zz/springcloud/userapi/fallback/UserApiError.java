package com.zz.springcloud.userapi.fallback;

import com.github.pagehelper.PageInfo;
import com.zz.springcloud.userapi.api.UserApi;
import com.zz.springcloud.userapi.pojo.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserApiError implements UserApi {
    @Override
    public ResponseEntity<PageInfo<User>> showAll(int page, int pageSize,String fuzzy) {
        List<User> userList  = new ArrayList<>();
        User user = new User();
        user.setUserId(-1);
        userList.add(user);
        return new ResponseEntity<>(new PageInfo<>(userList),HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<User> showOne(User user) {
        User temp = new User();
        temp.setUserId(-1);
        return new ResponseEntity<>(temp,HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity update(User user) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
