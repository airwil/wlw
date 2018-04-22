package com.xz.wlw.service;

import com.xz.wlw.entity.Comment;

import java.util.List;

/**
 * @author
 * @date 2018/4/22 11:11
 */
public interface CommentService {
    int insert(Comment comment);

    List<Comment> selectByTid(int tid);
}
