package com.zz.springcloud.drug.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zz.springcloud.drug.dao.DrugDao;
import com.zz.springcloud.drug.service.DrugService;
import com.zz.springcloud.drugapi.pojo.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {
    @Autowired
    private DrugDao drugDao;

    @Override
    public PageInfo<Drug> showAll(int page,int pageSize) {
        PageHelper.startPage(page,pageSize);
        return new PageInfo<>(drugDao.selectAll(),5);
    }

    public List<Drug> showByFuzzy(String fuzzy){
        Example example = new Example(Drug.class);
        example.and()
                .andLike("drugName","%"+fuzzy+"%")
                .orLike("drugDose","%"+fuzzy+"%")
                .orLike("drugNumber","%"+fuzzy+"%")
                .orLike("drugFunction","%"+fuzzy+"%")
                .orLike("drugPlace","%"+fuzzy+"%");
        return drugDao.selectByExample(example);
    }
}
