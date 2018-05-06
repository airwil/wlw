package com.xz.wlw.service.impl;

import com.xz.wlw.dao.TalkMapper;
import com.xz.wlw.entity.Talk;
import com.xz.wlw.service.TalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author
 * @date 2018/4/21 18:29
 */
@Service
public class TalkServiceImpl implements TalkService{
    @Autowired
    private TalkMapper talkMapper;

    @Override
    public int insert(Talk talk) {
        return talkMapper.insert(talk);
    }

    @Override
    public List<Talk> selectAll() {
        return talkMapper.selectAll();
    }

    @Override
    public Talk selectById(int id) {
        return talkMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Talk> selectTalkAndComms() {
        return talkMapper.selectTalkAndComms();
    }

    @Override
    public List<Talk> selectTalkMap(Map<String, Object> map) {
        return talkMapper.selectTalkMap(map);
    }

    @Override
    public int countTotal() {
        return talkMapper.countTotal();
    }

    @Override
    public int delTalk(int id) {
        return talkMapper.deleteByPrimaryKey(id);
    }
}
