package com.mvc.common.filter;

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

public class LogFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(LogFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		String remoteAddr = req.getRemoteAddr(); //IP주소
		String uri = req.getRequestURI();
		String url = req.getRequestURL().toString();
		String queryString = req.getQueryString();

		String referer = req.getHeader("referer"); //이전 페이지 url
		String agent = req.getHeader("User-Agent"); // 사용자 정보 (browser, os 등...)

		StringBuffer sb = new StringBuffer();

		sb.append("remoteAddr : " + remoteAddr + "\n")
		.append("* uri : " + uri + "\n")
		.append("* url : " + url + "\n")
		.append("* queryString : " + queryString + "\n")
		.append("* referer : " + referer + "\n")
		.append("* agent : " + agent);

		logger.info("LOG FILTER\n" + sb);

		chain.doFilter(req, response);

	}

	@Override
	public void destroy() {

	}

}
