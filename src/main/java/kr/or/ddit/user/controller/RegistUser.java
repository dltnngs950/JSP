package kr.or.ddit.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/registUser")
public class RegistUser extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(RegistUser.class);
	private UserServiceI userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		req.getRequestDispatcher("/user/registUser.jsp").forward(req, resp);
			
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String userid = req.getParameter("userid");
		String usernm = req.getParameter("usernm");
		String pass = req.getParameter("pass");
		String alias = req.getParameter("alias");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String zipcode = req.getParameter("zipcode");

		UserVo userVo = new UserVo();
		userVo.setUserid(userid);
		userVo.setUsernm(usernm);
		userVo.setPass(pass);
		userVo.setAlias(alias);
		userVo.setAddr1(addr1);
		userVo.setAddr2(addr2);
		userVo.setZipcode(zipcode);
		
		int insertCnt = userService.registUser(userVo);
		
		if (insertCnt == 1) {
			resp.sendRedirect(req.getContextPath() + "pagingUser?page=1&pageSize=5");
		} else {
			logger.debug("########### {}",userid);
			req.setAttribute("userVo", userVo);
			doGet(req, resp);
		}

	}

}
