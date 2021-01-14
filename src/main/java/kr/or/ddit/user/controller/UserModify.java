package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

@WebServlet("/userModify")
public class UserModify extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(UserModify.class);
	private UserServiceI userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String userid = req.getParameter("userid");
		UserVo user = userService.selectUser(userid);
		
		req.setAttribute("user", user);
		req.getRequestDispatcher("/user/userModify.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		// 파라미터를 읽기 전에 CharacterEncoding을 해줘야 한다..! 가급적 맨 위에 세팅
		// servlet의 doGet 메소드 마다 실행 필요 ==> Filter
		req.setCharacterEncoding("UTF-8");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		
		String userid = req.getParameter("userid");
		String usernm = req.getParameter("usernm");
		String pass = req.getParameter("pass");
		Date reg_dt = null;
		try {
			reg_dt = sdf.parse(req.getParameter("reg_dt"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String alias = req.getParameter("alias");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String zipcode = req.getParameter("zipcode");

		UserVo userVo = new UserVo();
		userVo.setUsernm(usernm);
		userVo.setPass(pass);
		userVo.setReg_dt(reg_dt);
		userVo.setAlias(alias);
		userVo.setAddr1(addr1);
		userVo.setAddr2(addr2);
		userVo.setZipcode(zipcode);
		userVo.setUserid(userid);
		
		int userCnt = userService.modifyUser(userVo);
		
		req.setAttribute("userCnt", userCnt);
		
		if(userCnt == 1) {
			// 사용자 아이디 정보를 가지고가므로 redirect를 하는게 수월하다.
			 resp.sendRedirect(req.getContextPath() + "/user?userid=" + userid);
		}else {
			 doGet(req, resp);
		}
			
	}

	// 사용자정보 수정 요청 처리
	
}
