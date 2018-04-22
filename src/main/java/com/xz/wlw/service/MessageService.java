package com.xz.wlw.service;

import com.xz.wlw.entity.Message;

import java.util.List;
import java.util.Map;

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

	/**
	 * 数量
	 */
	int countAll();
}
