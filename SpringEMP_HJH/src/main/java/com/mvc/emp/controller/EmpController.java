package com.mvc.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.emp.biz.EmpBiz;

@Controller
public class EmpController {
	
	@Autowired
	private EmpBiz biz;
	
	@RequestMapping("/list.do")
	public String selectList(Model model) {
		model.addAttribute("list", biz.selectList());
		
		return "list";
	}
	
}
