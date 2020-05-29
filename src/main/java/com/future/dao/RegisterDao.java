package com.future.dao;

import com.future.entity.Register;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface RegisterDao {
    public Integer addRegister(Register register);//添加挂号

    List<Register> showRegister(Register register);

    int getRegisterCount(Register register);

    Integer yyRegister(@Param("register") Register register);
}
