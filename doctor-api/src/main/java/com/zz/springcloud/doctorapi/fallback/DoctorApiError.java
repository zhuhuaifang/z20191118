package com.zz.springcloud.doctorapi.fallback;

import com.github.pagehelper.PageInfo;
import com.zz.springcloud.doctorapi.api.DoctorApi;
import com.zz.springcloud.doctorapi.pojo.Doctor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class DoctorApiError implements DoctorApi {
    @Override
    public ResponseEntity<PageInfo<Doctor>> showAll(int page, int pageSize, String fuzzy) {
        List<Doctor> doctors = new ArrayList<>();
        Doctor doctor = new Doctor();
        doctor.setDId(-1);
        doctors.add(doctor);
        return new ResponseEntity<>(new PageInfo<>(doctors), HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Doctor> showOne(Doctor doctor) {
        return null;
    }

    @Override
    public ResponseEntity update(Doctor doctor) {
        return null;
    }
}
