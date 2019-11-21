package com.zz.springcloud.drugapi.api;

import com.github.pagehelper.PageInfo;
import com.zz.springcloud.drugapi.fallback.DrugApiError;
import com.zz.springcloud.drugapi.pojo.Drug;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "drug",fallback = DrugApiError.class)
public interface DrugApi {
    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public PageInfo<Drug> showAll(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize);


}
