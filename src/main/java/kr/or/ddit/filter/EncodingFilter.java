package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EncodingFilter implements Filter{
	
	private static final Logger logger = LoggerFactory.getLogger(EncodingFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
			logger.debug("initEncodingFilter");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		
	}

}
