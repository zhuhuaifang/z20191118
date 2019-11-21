package com.zz.springcloud.userapi.api;

import com.github.pagehelper.PageInfo;
import com.zz.springcloud.userapi.fallback.UserApiError;
import com.zz.springcloud.userapi.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user",fallback = UserApiError.class)
public interface UserApi {
    @RequestMapping(value = "/show")
    public ResponseEntity<PageInfo<User>> showAll(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize,@RequestParam(value = "fuzzy",required = false)String fuzzy);

    @RequestMapping(value = "/showOne")
    public ResponseEntity<User> showOne(User user);

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public ResponseEntity update(User user);
}
