package com.zz.springcloud.doctorapi.pojo;

import java.io.Serializable;
import lombok.Data;
import org.junit.Test;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * (Doctor)实体类
 *
 * @author makejava
 * @since 2019-11-21 15:52:56
 */
@Data
@Table(name = "doctor")
public class Doctor implements Serializable {
    private static final long serialVersionUID = 490961321034717879L;

    @Id
    private Integer dId;
    //医生姓名
    private String dName;
    //科室
    private String dKeshi;
    //职位
    private String dZhiwei;
    //价钱
    private Double dPrice;
    //评分
    private Double dPingfen;
    //执业编号
    private String dNum;
    //主治疾病
    private String dZhuzhi;
    //接待服务人数
    private String dJiedai;
    //好评数
    private String dHaopin;
    //简介擅长
    private String dJianjie;
    //擅长
    private String dShanchang;
    //医生头像
    private String dImg;


}