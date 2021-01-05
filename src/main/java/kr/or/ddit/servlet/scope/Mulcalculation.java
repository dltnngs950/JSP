package kr.or.ddit.servlet.scope;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Mulcalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("jsp/sumResult.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int fir = Integer.parseInt(request.getParameter("fir"));
		int sec = Integer.parseInt(request.getParameter("sec"));
		
		HttpSession session = request.getSession();
		
		// 곱하기
		int mul = 1;
		mul = fir * sec;
		
		session.setAttribute("sumResult1", mul);
		
		request.getRequestDispatcher("jsp/sumResult.jsp").forward(request, response);
		
	}

}
