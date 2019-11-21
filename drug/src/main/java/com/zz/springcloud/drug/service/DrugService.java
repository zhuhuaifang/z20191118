package com.zz.springcloud.drug.service;

import com.github.pagehelper.PageInfo;
import com.zz.springcloud.drugapi.pojo.Drug;

import java.util.List;

public interface DrugService {
    PageInfo<Drug> showAll(int page,int pageSize);
    List<Drug> showByFuzzy(String fuzzy);
}
