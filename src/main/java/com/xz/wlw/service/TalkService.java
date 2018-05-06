package com.xz.wlw.service;

import com.xz.wlw.entity.Talk;

import java.util.List;
import java.util.Map;

/**
 * 技术交流
 * @author
 * @date 2018/4/21 18:26
 */
public interface TalkService {
    /**
     * 新增
     */
    int insert(Talk talk);

    /**
     * 查询所有
     */
    List<Talk> selectAll();

    /**
     * 根据id查询帖子
     */
    Talk selectById(int id);

    /**
     * 帖子名称和回复数
     */
    List<Talk> selectTalkAndComms();

    /**
     * 分页查询
     */
    List<Talk> selectTalkMap(Map<String, Object> map);

    int countTotal();

    int delTalk(int id);
}
