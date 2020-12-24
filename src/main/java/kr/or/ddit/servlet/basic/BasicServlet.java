package kr.or.ddit.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	// doXXX 메소드의 인자 : req, res ( 표준 스펙 ) 
	// GET, POST, DELETE, PUSH, HEAD etc.. ==> Http 메서드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 재정의
		PrintWriter pw = resp.getWriter();
		pw.println("Hello, World");
		
		pw.flush();		// 더 이상 작성할 내용이 없으면 작업을 마무리 한다
		pw.close();		// 사용한 자원을 반납
		
		super.doGet(req, resp);
	}
	
	
	
	

}
