package kr.or.ddit.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestCounterFilter implements Filter{
	
	private Map<String, Integer> requestCountMap = new HashMap<>();
	private static final Logger logger = LoggerFactory.getLogger(RequestCounterFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ServletContext sc = filterConfig.getServletContext();
		sc.setAttribute("requestCountMap", requestCountMap);
		
	}

	// filter.doFilter == servlet.service
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// request 객체를 이용하여 요청된 URI 정보를 카운팅
		HttpServletRequest req = (HttpServletRequest)request; 
		String uri = req.getRequestURI();
		
		logger.debug("request uri : {}", uri);
		
		// requestCountMap에 uri에 해당 키각 있을수도 있고 없을수 도 있다.
		
		// 최초 요청인 경우
		if(requestCountMap.get(uri) == null) {
			requestCountMap.put(uri, 1);
		}
		else {
			int requestCount = requestCountMap.get(uri);
			requestCountMap.put(uri, requestCount + 1);
		}
		
//		ServletContext sc =  req.getServletContext();
//		sc.setAttribute
		
		// 다른 필터가 있을경우 필터로, 필터가없을 경우 해당 요청을 처리하는 servlet, jsp로 요청 위임
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	

}
