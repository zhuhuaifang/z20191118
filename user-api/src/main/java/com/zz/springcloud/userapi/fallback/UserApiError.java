package com.zz.springcloud.userapi.fallback;

import com.github.pagehelper.PageInfo;
import com.zz.springcloud.userapi.api.UserApi;
import com.zz.springcloud.userapi.pojo.Users;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserApiError implements UserApi {
    @Override
    public PageInfo<Users> showAll() {
        List<Users> usersList  = new ArrayList<>();
        Users users = new Users();
        users.setUserId(-1);
        usersList.add(users);
        return new PageInfo<>(usersList);
    }
}
