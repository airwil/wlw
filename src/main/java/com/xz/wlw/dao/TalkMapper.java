package com.xz.wlw.dao;

import com.xz.wlw.entity.Talk;

import java.util.List;

public interface TalkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Talk record);

    int insertSelective(Talk record);

    Talk selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Talk record);

    int updateByPrimaryKeyWithBLOBs(Talk record);

    int updateByPrimaryKey(Talk record);

    List<Talk> selectAll();

    List<Talk> selectTalkAndComms();
}