package com.mvc.ex01.model;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mvc.ex01.model.biz.boardBizImpl;
import com.mvc.ex01.model.dto.boardDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	boardBizImpl biz;
	
	private int res;
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		 
		return "home";
	}
	
	@RequestMapping(value="/list.do", method = RequestMethod.GET)
	public String list(Model model) {
		
		logger.info("게시글 전체 보기");
		
		model.addAttribute("list", biz.selectList());
		
		return "mvclist";
	}
	
	@RequestMapping(value="/insertform.do")
	public String insertFormOpen() {
		
		return "mvcinsert";
	}
	
	@RequestMapping(value="/insertres.do", method = RequestMethod.POST)
	public String boardIsnert(boardDto dto, RedirectAttributes redirectAttr) {
		
		res = biz.insert(dto);
		redirectAttr.addFlashAttribute("res",res); 
		
		return "redirect:list.do";
	}
	
	@RequestMapping(value="/detail.do", method = RequestMethod.GET)
	public String selectOne(int myno, Model model) {
		
		model.addAttribute("dto", biz.selectOne(myno));
		
		return "mvcdetail";
	}
	
	@RequestMapping(value="/updateform.do", method = RequestMethod.GET)
	public String updateFormOpen(int myno, Model model) {
		
		model.addAttribute("dto", biz.selectOne(myno));
		
		return "mvcupdate";
	}
	
	@RequestMapping(value="/updateres.do", method = RequestMethod.POST)
	public String update(boardDto dto, RedirectAttributes redirectAttr) {
		
		res = biz.update(dto);
		redirectAttr.addFlashAttribute("res", res);
		 
		return "redirect:list.do";
	}
	
	@RequestMapping(value="/delete.do", method = RequestMethod.GET)
	public String delete(int myno, RedirectAttributes redirectAttr) {
		
		res = biz.delete(myno);
		redirectAttr.addFlashAttribute("res", res);
		
		return "redirect:list.do";
		
	}
}