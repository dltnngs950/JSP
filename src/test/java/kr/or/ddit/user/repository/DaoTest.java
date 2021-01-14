package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public class DaoTest {

	   @Test
	   public void selectAllUserTest() {
	      /***Given***/
	      UserDaoI userDao = new UserDao();
	      
	      /***When***/
	      List<UserVo> userList = userDao.selectAllUser();

	      /***Then***/
	      assertEquals(16, userList.size());
	   }
	   
	   // 사용자 아이디를 이용하여 특정 사용자정보 조회
	   @Test
	   public void selectUser() {
		   /***Given***/
		   	UserDaoI userDao = new UserDao();
		   	String userid = "brown";

		   /***When***/
		   	UserVo user = userDao.selectUser(userid);
		   /***Then***/
		   	assertEquals("브라운", user.getUsernm());
	   }
	   
	   // 사용자 페이징 조회
	   @Test
	   public void selectPagingUser() {
		   /***Given***/
		   	UserDaoI userDao = new UserDao();
		   	PageVo vo = new PageVo(2, 5);
//		   	vo.setPage(2);
//		   	vo.setPageSize(5);
		   	
		   /***When***/
		   	List<UserVo> pagingUserList = userDao.selectPagingUser(vo);
		   /***Then***/
		   	assertEquals(5, pagingUserList.size());
	   }
	   
	   @Test
	   public void modifyUserTest() {
		   /***Given***/
		   UserDaoI userDao = new UserDao();
		   
		   // userid, usernm, pass, reg_dt, alias, addr1, addr2, zipcode
		   UserVo userVo = new UserVo("ddit", "대덕인재", "dditpass", new Date(), 
				   			"개발원 m", "대전시 중구 중앙로 76", "4층 대덕인재개발원", "34940");

		   /***When***/
		   int updateCnt = userDao.modifyUser(userVo);
		   /***Then***/
		   assertEquals(1, updateCnt);

	   }
	   
	   
	   

}
