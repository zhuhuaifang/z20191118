package com.zz.springcloud.admin.controller;

import com.github.pagehelper.PageInfo;
import com.zz.springcloud.doctorapi.api.DoctorApi;
import com.zz.springcloud.doctorapi.pojo.Doctor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorApi doctorApi;

    @RequestMapping("/show")
    public ResponseEntity<PageInfo<Doctor>> showAll(@RequestParam(value = "page",defaultValue = "1") int page, @RequestParam(value = "pageSize",defaultValue = "5") int pageSize, @RequestParam(value = "fuzzy",required = false)String fuzzy){
        log.info(doctorApi.showAll(page,pageSize,fuzzy));
        return doctorApi.showAll(page,pageSize,fuzzy);
    }
}
