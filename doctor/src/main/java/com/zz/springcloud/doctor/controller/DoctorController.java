package com.zz.springcloud.doctor.controller;

import com.github.pagehelper.PageInfo;
import com.zz.springcloud.doctor.service.DoctorService;
import com.zz.springcloud.doctorapi.pojo.Doctor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class DoctorController {
    
    @Autowired
    private DoctorService doctorService;

    @RequestMapping(value = "/show")
    public ResponseEntity<PageInfo<Doctor>> showAll(int page, int pageSize, @RequestParam(value = "fuzzy", required = false) String fuzzy) {
        PageInfo<Doctor> doctors = null;
        if (fuzzy != null) {
            doctors = doctorService.showByFuzzy(page, pageSize, fuzzy);
        } else {
            doctors = doctorService.showAll(page, pageSize);
        }
        if (doctors == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @RequestMapping(value = "/showOne")
    public ResponseEntity<Doctor> showOne(@RequestBody Doctor doctor){
        log.info("----------------------------"+doctor);
        Doctor showOne = doctorService.showOne(doctor);
        if (showOne==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(showOne,HttpStatus.OK);
    }

    @RequestMapping(value = "/update")
    public ResponseEntity update(@RequestBody Doctor doctor){
        Boolean update = doctorService.update(doctor);
        if (update){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
