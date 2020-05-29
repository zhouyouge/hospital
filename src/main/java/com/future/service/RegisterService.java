package com.future.service;

import com.future.entity.Register;
import com.future.entity.ResponseParam;

import java.util.List;

public interface RegisterService {
    public Integer addRegister(Register register);//添加挂号

    List<Register> showRegister(Register register);

    int getRegisterCount(Register register);

    ResponseParam yyRegister( Register register);
}
