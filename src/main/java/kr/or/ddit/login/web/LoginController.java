package kr.or.ddit.login.web;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

/* web.xml에 설정하는 servlet, servlet-mapping을 어노테이션을 통해 설정하는 방법 */
@WebServlet("/loginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	private static UserServiceI userService = new UserService();
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// 클라이언트가 서버로 요청을 보낼시 브라우저에 의해 같이 전송된 쿠키 정보 확인 
	      Cookie[] cookies = request.getCookies();
	      for(Cookie cookie : cookies) {
	         logger.debug("cookie.getName() : {} / cookie.getValue() : {} ", cookie.getName(), cookie.getValue());
	         
	         // 응답 전송시 쿠키를 생성해서 같이 보내준다
	         if(cookie.getName().equals("userid")) {
	            Cookie newServerCookie = new Cookie("newServerCookie", "testValue");
	            response.addCookie(newServerCookie);
	         }
	      }
	      
		
		// 로그인 성공시 main.jsp로 이동
		// 로그인 프로세스
		// DB에 저장된 사요자 정보와 일치하는지 검증해야하나, DB연동이 아직 준비되지 않은관계로
		// userId == brown 일 때 비밀번호가 brownPass 인 경우 한해 로그인이 성공되었다고 판단
		// 그 외 경우는 로그인 실패로 간주
		
		// 로그인 성공시 : main.jsp로 forward
		// forward : 요청을 처리할 다른 JSP, servlet 에게 위임 
		//		     서버 안에서 이루어지는 작업으로 클라잉너트 입장에서는 누가 응답을 생성 했는지 알 수 없다
		// 			 request.getRequestDispatcher(url)을 이용하여 requestDispatcher
		//			 객체를 얻어 forward(request, response)를 실행
		//			** 같은 웹 어플리케이션 안에서 일어나는 일이므로 contextPath를 지정하지 않는다
		
		// 로그인 실패시 : login.jsp로 redirect(문법적으로 배우기 위해, 올바른 상황에 대해서는 추후 다시)
		// 	redirect : 클라이언트에게 정해진 주소로 재요청 할 것을 지시
		//				redirect 응답을 받은 클라이언트는 재요청 주소로 서버에게 요청한다
		// 				원 요청 + 재요청 : 요청이 총 2번 필요
		// 				response.sendRedirect("클라이언트가 새롭게 요청할 주소");
		//
		
		// 1. userId, pass 파라미터를 문자열 변수에 저장
	    // 2. userId pass 값이 지정한 값과 일치하는지 비교
	      // 3. 2번 비교 사항이 true일 때 webApp/main.jsp로 forward ( main.jsp는 생성 )
	      // 4. 2번 비교 사항이 false일 때 webApp/login.jsp로 redirect 
	      
		String userid = request.getParameter("userid");
		String pass = request.getParameter("pass");
		
		UserVo user = userService.selectUser(userid);
		logger.debug(userid);
		logger.debug(user.getPass());
			
		if( user != null && pass.equals(user.getPass())) { // 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("S_USER", user);
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}else {// 로그인 실패
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
		
		
		
		
	}


}
