package com.future.service.impl;

import com.future.dao.RegisterDao;
import com.future.entity.Register;
import com.future.entity.ResponseParam;
import com.future.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.DecimalFormat;
import java.util.List;

/*引入Service层*/
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    RegisterDao registerDao;

    //注入接口
    @Override
    public Integer addRegister(Register register) {
        return registerDao.addRegister(register);
    }

    @Override
    public List<Register> showRegister(Register register) {
        if (!StringUtils.isEmpty(register.getToseedoctor())) {
            String sub = register.getToseedoctor();
            sub = sub.substring(0, 7);
            register.setToseedoctorStart(sub);
        }
        return registerDao.showRegister(register);
    }

    @Override
    public int getRegisterCount(Register register) {
        return registerDao.getRegisterCount(register);
    }

    @Override
    public ResponseParam yyRegister(Register re) {
        ResponseParam rp = new ResponseParam();
        Register register = new Register();
        //bbb -医生编号  doctorid     aaaabbbcdddd
        DecimalFormat df = new DecimalFormat("000");
        String doctor = df.format(re.getDoctorid());

        //aaaa-预约时间  registerData
        String registerData = re.getRegisterData();
        String data = registerData.substring(5, registerData.length());
        String newData = data.replace("-", "");

        //c-预约状态（0-就诊/1-未就诊）
        String status = "0";//默认0   （0-就诊/1-未就诊）

        // dddd-今日人数0001
        String rs = "0001"; //取人数

        String toseedoctor = newData + doctor + status + rs;

        register.setDoctorid(re.getDoctorid());//医生id
        register.setCardid("5555555555");//卡号
        register.setToseedoctor(toseedoctor);
        Integer num = registerDao.yyRegister(register);
        if(num ==1){
            rp.setData(num);
            rp.setCode(0);
            rp.setMsg("预约/挂号成功");
        }else{
            rp.setMsg("预约/挂号失败");
        }

        return rp;
    }



}
