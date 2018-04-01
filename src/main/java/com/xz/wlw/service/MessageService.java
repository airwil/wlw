package com.xz.wlw.service;

import java.util.List;
import java.util.Map;

import com.xz.wlw.entity.Message;

/**
 * 留言接口
 * @author ThinkPad
 *
 */
public interface MessageService {

	/**
	 * 新增留言
	 */
	public void addMessage(Message message);
	
	/**
	 * 查询留言
	 */
	public List<Message> findMessage(Map<String, Object> map);
	
	/**
	 * 删除留言
	 */
	public int deleteMessage(int id);
}
