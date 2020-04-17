package com.mvc.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.test.dto.AddressDto;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/command.do", method = RequestMethod.GET)
	public String getCommand(String name, String addr, String phone, Model model) {
		
		model.addAttribute("dto", new AddressDto(name, addr, phone));
		
		return "getCommand";
	}
	
	@RequestMapping(value="/command.do", method = RequestMethod.POST)
	public String postCommand(Model model, @ModelAttribute AddressDto dto) {
		
		model.addAttribute("dto", dto);
		
		return "postCommand";
	}
	
	// 리턴값이 없는 void 타입 같은 경우는 RequestMapping value의 do를 뺀 나머지 이름의 jsp 페이지로 이동
	@RequestMapping(value="/void.do")
	public void voidPage(Model model) {
		model.addAttribute("msg","void page");		
	}
	
	
}
