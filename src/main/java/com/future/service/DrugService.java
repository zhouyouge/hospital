package com.future.service;

import com.future.entity.Drug;

import java.util.List;

public interface DrugService {

    /**
     * 查看药品信息service层
     * @return
     */
    List<Drug> getDrList(Drug drug);

    /**
     * 增加药品信息service层
     * @return
     */
    Boolean addDrug(Drug drug);

    /**
     * 删除药品信息service层
     * @return
     */
    Boolean delDrug(Drug drug);

    /**
     * 修改药品信息service层
     * @return
     */
    Boolean updateDrug(Drug drug);

}
