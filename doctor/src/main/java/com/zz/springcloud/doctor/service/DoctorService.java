package com.zz.springcloud.doctor.service;

import com.github.pagehelper.PageInfo;
import com.zz.springcloud.doctorapi.pojo.Doctor;

public interface DoctorService {
    PageInfo<Doctor> showAll(int page, int pageSize);
    PageInfo<Doctor> showByFuzzy(int page,int pageSize,String fuzzy);
    Boolean update(Doctor doctor);
    Doctor showOne(Doctor doctor);
}
