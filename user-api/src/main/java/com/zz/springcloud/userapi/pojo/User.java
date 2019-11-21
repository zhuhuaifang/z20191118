package com.zz.springcloud.userapi.pojo;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2019-11-21 10:14:33
 */
@Data
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = -67999068551648385L;
    //用户id
    @Id
    @Column(name = "user_id")
    private Integer userId;
    //用户名
    private String userName;
    //用户密码
    private String password;
    //用户头像
    private String img;
    //用户电话
    private String telphone;
    //用户地址
    private String address;
    //用户邮箱
    private String email;
    //用户状态(0可登录，-1已冻结)
    private Integer status;


}