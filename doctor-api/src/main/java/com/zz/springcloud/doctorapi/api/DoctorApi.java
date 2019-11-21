package com.zz.springcloud.doctorapi.api;

import com.github.pagehelper.PageInfo;
import com.zz.springcloud.doctorapi.fallback.DoctorApiError;
import com.zz.springcloud.doctorapi.pojo.Doctor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "doctor",fallback = DoctorApiError.class)
public interface DoctorApi{
    @RequestMapping("/show")
    public ResponseEntity<PageInfo<Doctor>> showAll(@RequestParam(value = "page",defaultValue = "1")int page,@RequestParam(value = "pageSize",defaultValue = "1")int pageSize,@RequestParam(value = "fuzzy",required = false)String fuzzy);


    @RequestMapping(value = "/showOne")
    public ResponseEntity<Doctor> showOne(Doctor doctor);

    @RequestMapping(value = "/update")
    public ResponseEntity update(Doctor doctor);
}
