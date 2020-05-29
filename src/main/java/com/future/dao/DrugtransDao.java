package com.future.dao;

import com.future.entity.Drugtrans;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("drugtransDao")
public interface DrugtransDao {

    /**
     * 查询所有药品交易记录
     * @return
     */
    List<Drugtrans> getDrugtransList(Drugtrans drugtrans);

    /**
     * 添加药品交易记录
     * @param drugtrans
     * @return
     */
    int addDrugtrans(Drugtrans drugtrans);

    /**
     * 删除药品交易记录
     * @param drugtrans
     * @return
     */
    int delDrugtrans(Drugtrans drugtrans);

    /**
     * 修改药品交易记录
     * @param drugtrans
     * @return
     */
    int updateDrugtrans(Drugtrans drugtrans);

}
