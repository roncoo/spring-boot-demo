package com.roncoo.example.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.roncoo.example.bean.RoncooUserLog;
import com.roncoo.example.cache.RoncooUserLogCache;

/**
 * @author wujing
 */
@RestController
@RequestMapping(value = "/rest", method = RequestMethod.POST)
public class RestRoncooController {

	@Autowired
	private RoncooUserLogCache RoncooUserLogCache;

	@RequestMapping(value = "/update")
	public RoncooUserLog update(@RequestBody JsonNode jsonNode) {
		System.out.println("jsonNode=" + jsonNode);
		RoncooUserLog bean = RoncooUserLogCache.selectById(jsonNode.get("id").asInt(1));
		if(bean == null){
			bean = new RoncooUserLog();
		}
		bean.setUserName("测试");
		bean.setCreateTime(new Date());
		bean.setUserIp("192.168.1.1");
		RoncooUserLogCache.updateById(bean);
		return bean;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public RoncooUserLog update2(@PathVariable(value = "id") Integer id) {
		RoncooUserLog bean = RoncooUserLogCache.selectById(id);
		if(bean == null){
			bean = new RoncooUserLog();
		}
		bean.setUserName("测试");
		bean.setCreateTime(new Date());
		bean.setUserIp("192.168.1.1");
		RoncooUserLogCache.updateById(bean);
		return bean;
	}

}
