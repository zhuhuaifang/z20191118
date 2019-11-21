package com.zz.springcloud.doctor.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zz.springcloud.doctor.dao.DoctorDao;
import com.zz.springcloud.doctor.service.DoctorService;
import com.zz.springcloud.doctorapi.pojo.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorDao doctorDao;

    @Override
    public PageInfo<Doctor> showAll(int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Doctor> doctors = doctorDao.selectAll();
        return new PageInfo<>(doctors,5);
    }

    @Override
    public PageInfo<Doctor> showByFuzzy(int page, int pageSize, String fuzzy) {
        Example example = new Example(Doctor.class);
        example.and()
                .andLike("dName","%"+fuzzy+"%")
                .orLike("dKeshi","%"+fuzzy+"%")
                .orLike("dZhiwei","%"+fuzzy+"%")
                .orLike("dZhuzhi","%"+fuzzy+"%")
                .orLike("dShanchang","%"+fuzzy+"%");
        PageHelper.startPage(page,pageSize);
        List<Doctor> users = doctorDao.selectByExample(example);
        return new PageInfo(users,5);
    }

    @Override
    public Boolean update(Doctor doctor) {
        int update = doctorDao.updateByPrimaryKeySelective(doctor);
        if (update==0){
            return false;
        }
        return true;
    }

    @Override
    public Doctor showOne(Doctor doctor) {
        return doctorDao.selectOne(doctor);
    }
}
