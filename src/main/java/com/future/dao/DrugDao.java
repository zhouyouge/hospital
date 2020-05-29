package com.future.dao;

import com.future.entity.Drug;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("drugDao")
public interface DrugDao{

        /**
         * 查看商品信息dao层
         * @return
         */
        List<Drug> getDrugList(Drug drug);

        /**
         * 增加商品信息dao层
         * @return
         */
        int addDrug(Drug drug);

        /**
         * 删除商品信息dao层
         * @return
         */
        int delDrug(Drug drug);

        /**
         * 修改商品信息dao层
         * @return
         */
        int updateDrug(Drug drug);

    }
