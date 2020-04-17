package com.hello.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hello.mvc.model.biz.HelloBiz;

@Controller
public class HelloController {

	// TODO : 05. Biz(@Service) 호출
	@Autowired
	private HelloBiz biz;
	
	// TODO : 04. handler mapping(/hello.do)를 통해 controller의 메서드를 찾아옴
	@RequestMapping("/hello.do")
	public ModelAndView getHello() {
		
		ModelAndView mav = new ModelAndView();
		String msg = biz.getHello();
		
		// TODO : 09. 리턴받은 값을 model 객체에 담아서 전달
		mav.addObject("message", msg);
		mav.setViewName("/WEB-INF/views/hello.jsp");
		
		return mav;
	}
	
	@RequestMapping("/bye.do")
	public String getBye(String name, Model model) {
		
		model.addAttribute("message" , name);
		
		return "/WEB-INF/views/bye.jsp"; 
	}
	
	/*
	 * 	@RequestMapping 
	 *  - url을 class 또는 method와 mapping 시켜주는 역할
	 *  
	 *  @RequestParam
	 *  - key=value 형태로 넘어오는 파라미터를 mapping된 method의 파라미터로 지정
	 *  - 만일 키값과 파라미터값과 이름이 같으면 생략 가능
	 *  
	 *  @ModelAttribute
	 *  - form tag를 통해 넘어온 model을 mpaaing된 method의 파라미터로 지정 (POST)
	 *  
	 *  @SessionAttribute
	 *  - session에서 model의 정보를 유지하고 싶을 경우 사용
	 *  
	 */
	
}
