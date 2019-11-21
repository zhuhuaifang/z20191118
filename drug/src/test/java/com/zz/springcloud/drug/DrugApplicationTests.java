package com.zz.springcloud.drug;


import com.zz.springcloud.drug.dao.DrugDao;
import com.zz.springcloud.drug.service.DrugService;
import com.zz.springcloud.drugapi.pojo.Drug;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
public class DrugApplicationTests {

    @Autowired
    private DrugService drugService;

    @Autowired
    private DrugDao drugDao;

    @Test
    public void contextLoads() {
       //log.info("----"+drugService.showByFuzzy("片"));
        Example example = new Example(Drug.class);
        // 设置查询列
        //example.selectProperties("drugName");
        // 动态sql
        String fuzzy = "哈";
        example.and()
                //.andGreaterThan("score",90)
                .andLike("drugName","%"+fuzzy+"%")
                .orLike("drugDose","%"+fuzzy+"%")
                .orLike("drugNumber","%"+fuzzy+"%")
                .orLike("drugFunction","%"+fuzzy+"%")
                .orLike("drugPlace","%"+fuzzy+"%");
        // 去重
        //example.setDistinct(true);
        // 排序
        //example.orderBy("score").desc();
        List<Drug> drugs = drugDao.selectByExample(example);
        log.info(drugs);
    }

}
