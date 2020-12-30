package kr.or.ddit.login.web;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* web.xml에 설정하는 servlet, servlet-mapping을 어노테이션을 통해 설정하는 방법 */
@WebServlet("/loginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 사용자가 userid, pass 파라미터를 전송 했다는 가정으로 개발
		
		// 하나의 파라미터 확인
		logger.debug("하나의 파라미터 확인");
		logger.debug("request.getParameter(\"userid\") : {}", request.getParameter("userid"));
		logger.debug("requset.getParameter(\"pass\") : {}", request.getParameter("pass"));
		
		// 복수개의 값을 갖는 파라미터 확인
		logger.debug("복수개의 값을 갖는 파라미터 확인");
		logger.debug("requset.getParameterValues(\"uesrid\") :");
		for(String userid : request.getParameterValues("userid")) {
			logger.debug(userid);
		}
		
		// 요청에 담긴 파라미터 이름을 확인
		logger.debug("요청에 담긴 파라미터 이름을 확인");
		logger.debug("requset.getParameterNames() : {}", request.getParameterNames());
		
		Enumeration<String> enumeration = request.getParameterNames();
		while(enumeration.hasMoreElements()) {
			logger.debug(enumeration.nextElement());
		}
		
		// 요청에 담긴 파라미터를 관리하는 맵 객체 확인
		logger.debug("요청에 담긴 파라미터를 관리하는 맵 객체 확인");
		logger.debug("requset.getParamterMap() : {}", (Object)request.getParameterMap());
		
		Map<String, String[]> map = request.getParameterMap();
		Set<String> keys = map.keySet();
		
		Iterator<String> it = keys.iterator();
		
		while(it.hasNext()) {
			logger.debug("{}", map.get(it.next()));
		}
		
	}


}
