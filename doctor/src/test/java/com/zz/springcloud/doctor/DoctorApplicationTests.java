package com.zz.springcloud.doctor;

import com.github.pagehelper.PageInfo;
import com.zz.springcloud.doctor.dao.DoctorDao;
import com.zz.springcloud.doctor.service.DoctorService;
import com.zz.springcloud.doctorapi.pojo.Doctor;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
public class DoctorApplicationTests {

    @Autowired
    private DoctorService doctorService;

    @Test
    public void contextLoads() {
        PageInfo<Doctor> pageInfo = doctorService.showAll(1, 5);
        log.info(pageInfo);
    }

}
