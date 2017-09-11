package com.commonTest.demo15.mybatisGenerator.dao;

import com.commonTest.demo15.mybatisGenerator.model.FinancierSubscribe;

public interface FinancierSubscribeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FinancierSubscribe record);

    int insertSelective(FinancierSubscribe record);

    FinancierSubscribe selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FinancierSubscribe record);

    int updateByPrimaryKey(FinancierSubscribe record);
}