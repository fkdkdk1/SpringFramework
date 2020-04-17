package com.mvc.upgrade.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.upgrade.model.biz.MemberBiz;
import com.mvc.upgrade.model.dto.MemberDto;

@Controller
public class MemberController {
	
	// class.clazz : 클래스는 예약어라 못쓰니 . clazz 로 표현한 것일 뿐
	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberBiz biz;
	
	@RequestMapping("/loginform.do")
	public String loginFormOpen() {
		logger.info("Login Form Open");
		return "mvclogin";
	}
	
	@RequestMapping(value="/ajaxlogin.do", method = RequestMethod.POST)
	
	// @ResponseBody : java 객체를 response 객체에 binding
	// @RequestBody : request 객체에 담겨져 넘어오는 데이터를 java 객체에 binding
	
	@ResponseBody
	public Map<String, Boolean> ajaxLogin(HttpSession session,
			@RequestBody MemberDto dto){
		
		logger.info("Ajax Login");
		
		MemberDto res = biz.login(dto);
		
		boolean check = false;
		
		if(res != null) {
			session.setAttribute("login", res);
			check = true;
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		
		return map;
	}
}