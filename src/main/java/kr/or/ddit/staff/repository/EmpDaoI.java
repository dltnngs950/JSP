package kr.or.ddit.staff.repository;

import java.util.List;

import kr.or.ddit.staff.model.EmpVo;

public interface EmpDaoI {
	
	// 모든 직원 정보를 가져오기
	List<EmpVo> selectAllEmp();
}
