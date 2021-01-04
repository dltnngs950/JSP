package kr.or.ddit.servlet.scope;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Scope extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.getRequestDispatcher("/jsp/scope.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String scope = request.getParameter("name");
		// request : 속성명 = request, 속성값 = scope파라미터값 + "_request" 
		request.setAttribute("request", scope + "_requset");
		// session : 속성명 = session, 속성값 = scope파라미터값 + "_session"
		HttpSession session = request.getSession();
		session.setAttribute("session", scope + "_session");
		// application : 속성명 = application, 속성값 = scope파라미터값 + "_application"
		ServletContext application = getServletContext();
		application.setAttribute("application", scope + "_application");
		
		request.getRequestDispatcher("jsp/scopeResult.jsp").forward(request, response);

	}

}
