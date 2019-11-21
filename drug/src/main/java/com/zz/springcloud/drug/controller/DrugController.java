package com.zz.springcloud.drug.controller;

import com.github.pagehelper.PageInfo;
import com.zz.springcloud.drug.service.DrugService;
import com.zz.springcloud.drugapi.pojo.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DrugController {

    @Autowired
    private DrugService drugService;

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public PageInfo<Drug> showAll(int page,int pageSize){
        return drugService.showAll(page,pageSize);
    }

    @RequestMapping(value = "/fuzzy",method = RequestMethod.GET)
    public List<Drug> showByFuzzy(@RequestParam("fuzzy") String fuzzy){
        return drugService.showByFuzzy(fuzzy);
    }


}
