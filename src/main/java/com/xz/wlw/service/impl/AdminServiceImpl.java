package com.xz.wlw.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xz.wlw.dao.AdminMapper;
import com.xz.wlw.entity.Admin;
import com.xz.wlw.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService{

	@Resource
	private AdminMapper adminMapper;
	
	@Override
	public Admin login(Admin admin) {
		return adminMapper.login(admin);
	}

	@Override
	public int changPwd(Admin admin) {
		return adminMapper.updateByPrimaryKeySelective(admin);
	}

}
