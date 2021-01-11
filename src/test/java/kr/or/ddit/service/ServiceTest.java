package kr.or.ddit.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.repository.UserDao;
import kr.or.ddit.user.repository.UserDaoI;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

public class ServiceTest {
	
	   @Test
	   public void selectAllUserTest() {
	      /***Given***/
	      UserServiceI userService = new UserService();
	      
	      /***When***/
	      List<UserVo> userList = userService.selectAllUser();

	      /***Then***/
	      assertEquals(16, userList.size());
	   }
	   
	   // 사용자 아이디를 이용하여 특정 사용자정보 조회
	   @Test
	   public void selectUser() {
		   /***Given***/
		   UserServiceI userService = new UserService();
		   	String userid = "brown";

		   /***When***/
		   	UserVo user = userService.selectUser(userid);
		   /***Then***/
		   	assertNotNull(user);
		   	assertEquals("브라운", user.getUsernm());
	   }
	   
	   // 사용자 아이디를 이용하여 특정 사용자정보 조회
	   @Test
	   public void selectUserNotExists() {
		   /***Given***/
		   UserServiceI userService = new UserService();
		   String userid = "brownNotexists";

		   /***When***/
		   UserVo user = userService.selectUser(userid);
		   /***Then***/
		   assertNotNull(user);
	   }
	   
	   // 사용자 페이징 조회
	   @Test
	   public void selectPagingUser() {
		   /***Given***/
		   UserServiceI userService = new UserService();
		   	PageVo vo = new PageVo(2, 5);
//		   	vo.setPage(2);
//		   	vo.setPageSize(5);
		   	
		   /***When***/
		   	List<UserVo> pagingUserList = userService.selectPagingUser(vo);
		   /***Then***/
		   	assertEquals(5, pagingUserList.size());
	   }
	   

}
