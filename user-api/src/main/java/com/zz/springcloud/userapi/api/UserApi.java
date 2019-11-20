package com.zz.springcloud.userapi.api;

import com.github.pagehelper.PageInfo;
import com.zz.springcloud.userapi.fallback.UserApiError;
import com.zz.springcloud.userapi.pojo.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "user",fallback = UserApiError.class)
public interface UserApi {
    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public PageInfo<Users> showAll();
}
