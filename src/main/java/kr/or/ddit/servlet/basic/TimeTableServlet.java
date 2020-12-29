package kr.or.ddit.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class TimeTableServlet
 */
public class TimeTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger Logger = LoggerFactory.getLogger(BasicServlet.class);  

		@Override
		public void init() throws ServletException {
			System.out.println("TimeTableServlet.init()");
		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Logger.debug("TimeTableServlet.doGet()");
		
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>TimeTable Servlet</title>");
		pw.println("<style>");
		pw.println("table{");
		pw.println("	border : 1px solid lightgray;");
		pw.println("	margin : 50px;");
		pw.println("	width : 100%;");
		pw.println("	text-align : center;");
		pw.println("}");
		pw.println("</style>");
		pw.println("</head>");
		pw.println("<body> <table border='1'>");
		int a = 1;
		int b = 2;
		for(int i = 1; i <= 9; i++) {
			
			pw.println("<tr>");
			for(int j = 1; j <= 8; j++) {
			pw.println("<td>" + b + " * " + a + " = " + (i*a) + "</td>");	
			b++;
			if( b>9) {
				b = 2;
			}
			}
			
			a++;
			
		pw.println("</tr>");
		}
		
		pw.println("</table>");
		pw.println("</body>");
		
		pw.println("</html>");
		
		
		pw.flush();		// 더 이상 작성할 내용이 없으면 작업을 마무리 한다
		pw.close();		// 사용한 자원을 반납
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
