package com.xz.wlw.dao;

import com.xz.wlw.entity.Solution;

import java.util.List;
import java.util.Map;

public interface SolutionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Solution record);

    int insertSelective(Solution record);

    Solution selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Solution record);

    int updateByPrimaryKeyWithBLOBs(Solution record);

    int updateByPrimaryKey(Solution record);

    List<Solution> selectAll(Map<String, Object> map);

    int countAll();
}