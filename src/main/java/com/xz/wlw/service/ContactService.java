package com.xz.wlw.service;

import com.xz.wlw.entity.Contact;

/**
 * 
 * 联系方式接口
 *
 */
public interface ContactService {

	/**
	 * 查询联系方式
	 * @return
	 */
	public Contact selectAll();
	
	/**
	 * 修改联系方式
	 */
	public int update(Contact contact);
}
