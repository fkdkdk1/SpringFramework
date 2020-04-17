package com.mvc.upgrade.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Filter : request와 response에 대한 정보들을 변경할 수 있게 개발자들에게 제공하는 서블릿 컨테이너 

public class LogFilter implements Filter {
	
	private Logger logger = LoggerFactory.getLogger(LogFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// method 요청이 있을때마다 실행
		// 1. request 파라미터를 이용하여 요청의 필터 작업 수행
		HttpServletRequest req = (HttpServletRequest)request;
		
		String remoteAddr = req.getRemoteAddr();		// 클라이언트의 IP 추출
		String uri = req.getRequestURI();				// 프로젝트 + 파일경로
		String url = req.getRequestURL().toString();	// 현재 페이지의 주소
		String queryString = req.getQueryString();		// get으로 전송된 쿼리문자열을 추출
		 
		String referer = req.getHeader("referer");		// 접속 경로 추출
		String agent = req.getHeader("User-Agent");		// 클라이언트의 시스템 정보
		
		StringBuffer sb = new StringBuffer();
		sb.append("remoteAddr : " + remoteAddr + "\n")
		  .append("* uri : " + uri + "\n")
		  .append("* url : " + url + "\n")
		  .append("* queryString : " + queryString + "\n")
		  .append("* referer : " + referer + "\n")
		  .append("* agent : " + agent);
		
		logger.info("LOG FILTER\n" + sb);
		
		chain.doFilter(request,  response);
		
		// 2. 체인의 다음 필터 처리
		// 3. response를 이용하여 응답의 필터링 작업 수행
	}

	@Override
	public void destroy() {
		// 4. 주로 필터가 사용한 자원을 반납

	}

}
