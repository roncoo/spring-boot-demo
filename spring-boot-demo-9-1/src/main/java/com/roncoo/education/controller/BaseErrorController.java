/**
 * 2015-2016 龙果学院 (www.roncoo.com)
 */
package com.roncoo.education.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wujing
 */
@Controller
@RequestMapping(value = "error")
public class BaseErrorController implements ErrorController {
	private static final Logger logger = LoggerFactory.getLogger(BaseErrorController.class);

	@Override
	public String getErrorPath() {
		logger.info("出错啦！进入自定义错误控制器");
		return "comm/error";
	}

	@RequestMapping
	public String error() {
		return getErrorPath();
	}

}
