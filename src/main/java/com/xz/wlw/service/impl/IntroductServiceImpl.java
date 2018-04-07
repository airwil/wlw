package com.xz.wlw.service.impl;

import com.xz.wlw.dao.IntroductMapper;
import com.xz.wlw.entity.Introduct;
import com.xz.wlw.service.IntroductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaowei
 * @date 2018/4/7 17:08
 */
@Service("introductService")
public class IntroductServiceImpl implements IntroductService{
    @Autowired
    private IntroductMapper introductMapper;

    @Override
    public List<Introduct> select() {
        return introductMapper.selectAll();
    }

    @Override
    public int update(Introduct introduct) {
        return introductMapper.updateByPrimaryKeySelective(introduct);
    }
}
