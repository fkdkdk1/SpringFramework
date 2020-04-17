package com.mvc.upgrade;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KakaopayController {
	
@RequestMapping("/kakaopay.do")
public String doKakaopay() {
	
	System.out.println("-----kakaopay-----");
	
	return "kakaopay";
	
}

}
