package com.xz.wlw.service.impl;

import com.xz.wlw.dao.MessageMapper;
import com.xz.wlw.entity.Message;
import com.xz.wlw.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

	@Resource
	private MessageMapper messageMapper;
	
	@Override
	public void addMessage(Message message) {
		messageMapper.insert(message);
	}

	@Override
	public List<Message> findMessage(Map<String, Object> map) {
		return messageMapper.findMessage(map);
	}

	@Override
	public int deleteMessage(int id) {
		return messageMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int countAll() {
		return messageMapper.getTotalMessages();
	}

}
