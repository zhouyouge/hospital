package com.future.service.impl;


import com.future.entity.Drug;
import com.future.entity.Drugtrans;
import com.future.entity.Prescription;
import com.future.service.DrugService;
import com.future.service.DrugtransService;
import com.future.service.PrescriptionService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class yanliangyongCeShiYong {
    ApplicationContext context;
    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring/application-spring.xml");
    }

    @After
    public void tearDown() throws Exception {
    }

    public static void main(String[] args) {
//        ApplicationContext  context = new ClassPathXmlApplicationContext("spring/application-spring.xml");
//        DrugtransService drugtransService = (DrugtransService) context.getBean("drugtransService");
//        List<Drugtrans> list = drugtransService.getDrugtransList();
//        for (Drugtrans dt :
//                list) {
//            System.out.println(dt.getId());

        ApplicationContext  context = new ClassPathXmlApplicationContext("spring/application-spring.xml");
        DrugService drugService = (DrugService) context.getBean("drugService");
        Drug d = new Drug();

            d.setId(4);
            d.setName("快克");
        drugService.addDrug(d);
            System.out.println(d.getId()+"  "+d.getName());

    }







    @Test
    public void getIllnessTypeList() {
       PrescriptionService prescriptionService = (PrescriptionService) context.getBean("prescriptionServiceImpl");
       List<Prescription> list = prescriptionService.getCureType();
        for (Prescription p :
                list) {
            System.out.println(p.getTypeid());
        }

    }
}