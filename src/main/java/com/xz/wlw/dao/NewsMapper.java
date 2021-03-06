package com.xz.wlw.dao;

import java.util.List;
import java.util.Map;

import com.xz.wlw.entity.News;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateByPrimaryKey(News record);
    
    List<News> selectAll(Map<String, Object> map);
    
    int countAllNews();
}