package com.xz.wlw.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.xz.wlw.dao.MessageMapper;
import com.xz.wlw.entity.Message;
import com.xz.wlw.service.MessageService;

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

}
