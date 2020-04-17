package com.mvc.upgrade;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.upgrade.model.biz.BoardBiz;
import com.mvc.upgrade.model.dto.BoardDto;


@Controller
public class HomeController {
	
	@Autowired
	private BoardBiz biz;
	
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

	
	@RequestMapping("/list.do")
	public String selectList(Model model, int page) {
		
		List<BoardDto> list = biz.selectList(page);
		model.addAttribute("list", list);
		model.addAttribute("page",biz.totalpage(page));
		
		return "mvclist";
	}

	@RequestMapping("/insertform.do")
	public String insertForm() {
		return "mvcinsert";
	}
	
	@RequestMapping(value = "/insertres.do", method = RequestMethod.POST)
	public String insertRes(BoardDto dto) {
		
		int res = biz.insert(dto);
		if(res > 0) {
			return "redirect:list.do";	
		} else {
			return "redirect:insertform.do";
		}
	}
	
	@RequestMapping("/detail.do")
	public String selectOne(Model model, int myno) {
		logger.info("SELECT ONE");
		
		model.addAttribute("dto", biz.selectOne(myno));
		
		return "mvcdetail";
	}
	
	
	@RequestMapping("/delete.do")
	public String delete(int myno) {
		logger.info("DELETE");
		
		int res = biz.delete(myno);
		if(res > 0) {
			return "redirect:list.do";
		} else {
			return "redirect:detail.do?myno="+myno;
		}
	}
	
	@RequestMapping("/updateform.do")
	public String updateForm(Model model, int myno) {
		logger.info("UPDATE FORM");
		
		BoardDto dto = biz.selectOne(myno);
		model.addAttribute("dto", dto);
		
		return "mvcupdate";
	}
	
	@RequestMapping(value = "/updateres.do", method = RequestMethod.POST)
	public String updateRes(BoardDto dto) {
		logger.info("UPDATE RESULT");

		int res = biz.update(dto);
		if(res > 0) {
			return "redirect:detail.do?myno="+dto.getMyno();
		} else {
			return "redirect:updateform.do?myno="+dto.getMyno();
		}
	}

}











