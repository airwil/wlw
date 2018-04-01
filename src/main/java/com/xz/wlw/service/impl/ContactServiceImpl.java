package com.xz.wlw.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xz.wlw.dao.ContactMapper;
import com.xz.wlw.entity.Contact;
import com.xz.wlw.service.ContactService;

@Service("contactService")
public class ContactServiceImpl implements ContactService {

	@Resource
	private ContactMapper contactMapper;
	
	@Override
	public Contact selectAll() {
		return contactMapper.selectAll();
	}

	@Override
	public int update(Contact contact) {
		// TODO Auto-generated method stub
		return contactMapper.updateByPrimaryKeySelective(contact);
	}

}
