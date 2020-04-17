package com.login.sociallogin;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	// 로그인 첫 화면 요청 메소드
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model, HttpSession session) {

		return "login";
	}

	// 카카오 로그인
	@RequestMapping(value = "/kakaoLogin", method = RequestMethod.POST)
	public String kakaoLogin(HttpSession session, String KAKAO_NICKNAME) {

		System.out.println(KAKAO_NICKNAME);
		session.setAttribute("sessionId", KAKAO_NICKNAME);

		return "login";
	}

	// 네이버 로그인
	@RequestMapping(value = "/naverLogin", method = RequestMethod.POST)
	public String naverLogin(Model model, HttpSession session, String NAVER_NAME) {

		System.out.println(NAVER_NAME);
		session.setAttribute("sessionId", NAVER_NAME);

		return "login";
	}

	// 로그아웃
	@RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpSession session) throws IOException {
		System.out.println("여기는 logout");
		session.invalidate();
		return "redirect:index.jsp";
	}
}
