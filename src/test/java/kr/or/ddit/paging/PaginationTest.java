package kr.or.ddit.paging;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.user.repository.UserDao;
import kr.or.ddit.user.repository.UserDaoI;

public class PaginationTest {

	@Test
	public void test() {
		/***Given***/
		int userTotCnt = 32;
		int pageSize = 5;
		
		

		/***When***/
//		int pagination  = (double)userTotCnt / pageSize;
		
		/***Then***/
//		assertEquals(4, pagination);
	}
	
	
	@Test
	public void selectAllUserCntTest() {
		/***Given***/
		UserDaoI userDao = new UserDao();
		int userTotCnt = 32;
		int pageSize = 5;

		/***When***/		
		int userCnt = userDao.selectAllUserCnt();
		
		/***Then***/
		assertEquals(16, userCnt);
	}

}
