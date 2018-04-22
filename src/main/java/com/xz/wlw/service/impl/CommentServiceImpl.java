package com.xz.wlw.service.impl;

import com.xz.wlw.dao.CommentMapper;
import com.xz.wlw.entity.Comment;
import com.xz.wlw.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaowei
 * @date 2018/4/22 11:12
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public int insert(Comment comment) {
        return commentMapper.insert(comment);
    }

    @Override
    public List<Comment> selectByTid(int tid) {
        return commentMapper.selectByTid(tid);
    }
}
