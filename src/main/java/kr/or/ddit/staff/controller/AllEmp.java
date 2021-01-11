package kr.or.ddit.staff.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.staff.model.EmpVo;
import kr.or.ddit.staff.service.EmpService;
import kr.or.ddit.staff.service.EmpServiceI;

public class AllEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		EmpServiceI empservice = new EmpService();
		
		List<EmpVo> emplist = empservice.selectAllEmp();
		
		request.setAttribute("emplist", emplist);
		
		request.getRequestDispatcher("/emp/allEmp.jsp").forward(request, response);
		
		

	}

}








