package kr.or.ddit.staff.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.staff.model.EmpVo;

public class EmpDao implements EmpDaoI{

	// 모든 직원 정보를 가져오기
	@Override
	public List<EmpVo> selectAllEmp() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<EmpVo> empliet = sqlSession.selectList("emp.selectAllEmp");	
		sqlSession.close();
		
		return empliet;
	}
	
	

}
