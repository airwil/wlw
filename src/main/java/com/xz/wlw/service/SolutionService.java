package com.xz.wlw.service;

import com.xz.wlw.entity.Solution;

import java.util.List;
import java.util.Map;

/**
 * @author 解决方案
 * @date 2018/4/6 20:16
 */
public interface SolutionService {
    /**
     * 添加
     */
    public int insert(Solution solution);

    /**
     * 删除
     */
    public int delete(int id);

    /**
     * 查询列表
     */
    public List<Solution> selectAll(Map<String, Object> map);

    /**
     * 根据id查询
     */
    public Solution selectById(int id);

    /**
     * 修改
     */
    public int update(Solution solution);

    /**
     * 统计总量
     */
    public int countAll();
}
