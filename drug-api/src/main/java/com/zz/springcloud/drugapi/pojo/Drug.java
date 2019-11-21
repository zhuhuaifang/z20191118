package com.zz.springcloud.drugapi.pojo;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * (Drug)实体类
 *
 * @author makejava
 * @since 2019-11-20 16:27:43
 */
@Data
@Table(name = "drug")
public class Drug implements Serializable {
    private static final long serialVersionUID = -86735151718540806L;
    //药品id
    @Id
    @Column(name = "drug_id")
    private Integer drugId;
    //药品名字
    private String drugName;
    //药品类型id
    private Integer drugTypeId;
    //药品价格
    private Double drugPrice;
    //药品批准号
    private String drugNumber;
    //药品产地
    private String drugPlace;
    //药品图片
    private String drugImg;
    //药物剂量
    private String drugDose;
    //药品规格
    private String drugSpec;
    //药品功能
    private String drugFunction;
    //药品生产日期
    private Date drugCreateDate;
    //有效期
    private String drugEffective;
    //药品销量
    private Integer drugSales;
    //药品状态（添加  0可售 -1 不可售）
    private Integer drugStatus;


}