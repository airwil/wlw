package com.xz.wlw.service;

import com.xz.wlw.entity.Introduct;

import java.util.List;

/**
 * 中心介绍
 * @author
 * @date 2018/4/7 17:03
 */
public interface IntroductService {

    /**
     * 查询
     */
    public List<Introduct> select();

    /**
     * 修改
     */
    public int update(Introduct introduct);
}
