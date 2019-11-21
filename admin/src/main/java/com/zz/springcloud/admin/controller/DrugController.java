package com.zz.springcloud.admin.controller;

import com.github.pagehelper.PageInfo;
import com.zz.springcloud.drugapi.api.DrugApi;
import com.zz.springcloud.drugapi.pojo.Drug;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@Log4j2
@RestController
@RequestMapping("/drug")
public class DrugController {
    @Autowired
    private DrugApi drugApi;

    @RequestMapping("/show")
    public PageInfo<Drug> showAll(@RequestParam(value = "page",defaultValue = "1") int page,@RequestParam(value = "pageSize",defaultValue = "5") int pageSize){
        //response.setHeader("Access-Control-Allow-Origin", "*");
        //response.setHeader("Cache-Control","no-cache");
        log.info(drugApi.showAll(page,pageSize));
        return drugApi.showAll(page,pageSize);
    }
}
