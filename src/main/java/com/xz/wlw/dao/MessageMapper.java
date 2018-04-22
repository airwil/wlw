package com.xz.wlw.dao;

import com.xz.wlw.entity.Message;
import java.util.List;
import java.util.Map;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
    
    List<Message> findMessage(Map<String, Object> map);
    
    int getTotalMessages(); 
}