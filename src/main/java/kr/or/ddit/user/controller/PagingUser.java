package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

public class PagingUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserServiceI userservice = new UserService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// left.jsp : /pagingUser?page=1&pageSize=5
		// ===> 	  /pagingUser
		
		// doGet 메소드에서 page, pageSize파라미터가 request객체에 존재하지 않을 때
		// page는 1로, pageSize는 5로 생각을 코드를 작성
		// 파라미터가 존재하면 해당 파라미터를 이용
		
		// primitive Type ==> class(Wrapper) Integer
		// if/else ==> ? // 조건 ? true 일때 반환할 값 : false일때 반환할 값
		// reFactoring : 코드를 (깔끔하게) 바꾸는데 기존 동작방식을 유지한채로 변경하는 기법
		
		String pageParam = request.getParameter("page");
		String pageSizeParam = request.getParameter("pageSize");
	
		int page = pageParam == null ? 1 : Integer.parseInt(pageParam);
		int pageSize = pageSizeParam == null ? 5 : Integer.parseInt(pageSizeParam);
		
		PageVo pageVo = new PageVo(page, pageSize);
		
		Map<String, Object> map = userservice.selectPagingUser(pageVo);
		
		List<UserVo> userlist = (List<UserVo>)map.get("userList");
		int userCnt = (int)map.get("userCnt");
		int pagination = (int)Math.ceil((double) userCnt / pageSize); 
		
		request.setAttribute("pageVo", pageVo);
		
		request.setAttribute("userlist", userlist);
		request.setAttribute("pagination", pagination);
		
		request.getRequestDispatcher("/user/pagingUser.jsp").forward(request, response);

	}

}
