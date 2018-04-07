package com.xz.wlw.service.impl;

import com.xz.wlw.dao.ResourceMapper;
import com.xz.wlw.entity.Resource;
import com.xz.wlw.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @date 2018/4/7 20:10
 */
@Service("ResourceService")
public class ResourceServiceImpl implements ResourceService{
    @Autowired
    private ResourceMapper resourceMapper;
    @Override
    public List<Resource> selectAll(Map<String, Object> map) {
        return resourceMapper.selectAll(map);
    }

    @Override
    public int countAll() {
        return resourceMapper.countAll();
    }

    @Override
    public Resource selectById(int id) {
        return resourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(int id) {
        return resourceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Resource resource) {
        return resourceMapper.updateByPrimaryKeySelective(resource);
    }

    @Override
    public int add(Resource resource) {
        return resourceMapper.insert(resource);
    }
}
