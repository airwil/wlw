package com.xz.wlw.service;

import com.xz.wlw.entity.Admin;

public interface AdminService {
	/**
	 * 登录
	 * 
	 */
	public Admin login(Admin admin);
	
	/**
	 * 修改密码
	 */
	public int changPwd(Admin admin);
}
