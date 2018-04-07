package com.xz.wlw.dao;

import com.xz.wlw.entity.Introduct;

import java.util.List;

public interface IntroductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Introduct record);

    int insertSelective(Introduct record);

    Introduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Introduct record);

    int updateByPrimaryKeyWithBLOBs(Introduct record);

    List<Introduct> selectAll();
}