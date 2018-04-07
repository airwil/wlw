package com.xz.wlw.service.impl;

import com.xz.wlw.dao.SolutionMapper;
import com.xz.wlw.entity.Solution;
import com.xz.wlw.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author
 * @date 2018/4/6 20:20
 */
@Service("solutionService")
public class SolutionServiceImpl implements SolutionService{

    @Autowired
    private SolutionMapper solutionMapper;

    @Override
    public int insert(Solution solution) {
        return solutionMapper.insert(solution);
    }

    @Override
    public int delete(int id) {
        return solutionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Solution> selectAll(Map<String, Object> map) {
        return solutionMapper.selectAll(map);
    }

    @Override
    public Solution selectById(int id) {
        return solutionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Solution solution) {
        return solutionMapper.updateByPrimaryKeySelective(solution);
    }

    @Override
    public int countAll() {
        return solutionMapper.countAll();
    }
}
