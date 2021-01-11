package kr.or.ddit.staff.service;

import java.util.List;

import kr.or.ddit.staff.model.EmpVo;

public interface EmpServiceI {
	
	// 모든 직원 정보를 가져오기
	List<EmpVo> selectAllEmp();

}
