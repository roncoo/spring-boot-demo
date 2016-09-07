/**
 * 2015-2016 龙果学院 (www.roncoo.com)
 */
package com.roncoo.education.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wujing
 */
@Controller
@RequestMapping(value = "/web")
public class WebController {

	@RequestMapping(value = "index")
	public String index(ModelMap map) {
		map.put("title", "thymeleaf hello word");
		return "index";
	}

}
