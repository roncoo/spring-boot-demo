package com.roncoo.example.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roncoo.example.bean.RoncooUser;
import com.roncoo.example.bean.RoncooUserLog;
import com.roncoo.example.dao.RoncooUserDao;
import com.roncoo.example.dao.RoncooUserLogDao;

@Service
public class UserService {

	@Autowired
	private RoncooUserDao roncooUserDao;

	@Autowired
	private RoncooUserLogDao roncooUserLogDao;

	/**
	 * 用户注册
	 * 
	 * @return
	 */
	@Transactional
	public String register(String name, String ip) {
		// 1.添加用户
		RoncooUser roncooUser = new RoncooUser();
		roncooUser.setName(name);
		roncooUser.setCreateTime(new Date());
		roncooUserDao.insert(roncooUser);
		
		// 测试使用
		//boolean flag = true;
		//if (flag) {
		//	throw new RuntimeException();
		//}

		// 2.添加注册日志
		RoncooUserLog roncooUserLog = new RoncooUserLog();
		roncooUserLog.setUserName(name);
		roncooUserLog.setUserIp(ip);
		roncooUserLog.setCreateTime(new Date());
		roncooUserLogDao.save(roncooUserLog);

		return "success";
	}

}
