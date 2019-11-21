package com.zz.springcloud.drug.dao;


import com.zz.springcloud.drugapi.pojo.Drug;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface DrugDao extends Mapper<Drug>, MySqlMapper<Drug> {

}
