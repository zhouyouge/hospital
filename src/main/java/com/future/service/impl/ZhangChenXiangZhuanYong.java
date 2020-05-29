package com.future.service.impl;

import com.future.entity.*;
import com.future.service.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ZhangChenXiangZhuanYong {
    ApplicationContext context;
    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring/application-spring.xml");
    }

    @After
    public void tearDown() throws Exception {
    }

    public static void main(String[] args) {
        ApplicationContext  context = new ClassPathXmlApplicationContext("spring/application-spring.xml");
        RegisterService registerService = (RegisterService) context.getBean("registerServiceImpl");
        Register register = new Register();
        register.setToseedoctor("0327003");
        List<Register> list =registerService.showRegister(register);
        System.out.println(register.toString());
        System.out.println(1);


    }


    @Test
    public void getIllnessTypeList() {


    }
}