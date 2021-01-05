package kr.or.ddit.servlet.scope;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.login.web.LoginController;

public class Sumcalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(Sumcalculation.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("jsp/calculation.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("basicServlet.ddPost()");
		
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		int sum = 0;
		
		// 누적 합
		HttpSession session = request.getSession();
		logger.debug("start : " + start);
		logger.debug("start : " + end);
		
		logger.debug("-------- 누적 합 시작 --------");
		for(int i = start; i <= end; i++) {	
			sum += i;	
			logger.debug("누적 값 : " + sum);
		}
		logger.debug("-------- 누적 합 끝 --------");
		logger.debug("결과 = " + sum);
			
		session.setAttribute("sumResult", sum);
		
		request.getRequestDispatcher("jsp/sumResult.jsp").forward(request, response);
		
		
		
	}

}
