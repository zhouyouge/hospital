package com.future.service;

import com.future.entity.Drugtrans;

import java.util.List;

public interface DrugtransService {

    /**
     * 查看交易记录表列表
     * @param drugtrans
     * @return
     */
    List<Drugtrans> getDrugtransList(Drugtrans drugtrans);

    /**
     * 增加交易记录
     * @param drugtrans
     * @return
     */
    Boolean addDrugtrans(Drugtrans drugtrans);

    /**
     * 删除交易记录
     * @param drugtrans
     * @return
     */
    Boolean delDrugtrans(Drugtrans drugtrans);

    /**
     * 修改交易记录
     * @param drugtrans
     * @return
     */
    Boolean updateDrugtrans(Drugtrans drugtrans);

}
