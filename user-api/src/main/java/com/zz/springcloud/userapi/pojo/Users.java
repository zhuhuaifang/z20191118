package com.zz.springcloud.userapi.pojo;

import lombok.Data;

import java.io.Serializable;


/**
 * (Users)实体类
 *
 * @author makejava
 * @since 2019-11-18 20:15:04
 */
@Data
public class Users implements Serializable {
    private static final long serialVersionUID = 672704214684525161L;
    
    private Integer userId;
    
    private String userName;
    
    private String password;


}