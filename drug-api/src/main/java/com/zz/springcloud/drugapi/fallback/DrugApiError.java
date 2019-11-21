package com.zz.springcloud.drugapi.fallback;

import com.github.pagehelper.PageInfo;
import com.zz.springcloud.drugapi.api.DrugApi;
import com.zz.springcloud.drugapi.pojo.Drug;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DrugApiError implements DrugApi {
    @Override
    public PageInfo<Drug> showAll(int page,int pageSize) {
        Drug drug = new Drug();
        drug.setDrugId(-1);
        List<Drug> drugs = new ArrayList<>();
        drugs.add(drug);
        return new PageInfo<Drug>(drugs);
    }
}
