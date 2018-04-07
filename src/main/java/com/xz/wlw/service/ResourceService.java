package com.xz.wlw.service;

import com.xz.wlw.entity.Resource;

import java.util.List;
import java.util.Map;

/**
 * @author
 * @date 2018/4/7 20:02
 */
public interface ResourceService {

    /**
     * 查询
     */
    List<Resource> selectAll(Map<String,Object> map);

    /**
     * 计数
     */
    int countAll();

    /**
     * 根据id查询
     */
    Resource selectById(int id);

    /**
     * 删除
     */
    int delete(int id);

    /**
     * 修改
     */
    int update(Resource resource);

    /**
     * 新增
     */
    int add(Resource resource);
}
