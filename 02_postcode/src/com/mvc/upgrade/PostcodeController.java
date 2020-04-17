package com.mvc.upgrade;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostcodeController {
	
@RequestMapping("/postcode.do")
public String doKakaopay() {
	
	System.out.println("-----postcode-----");
	
	return "postcode";
	
}

}
