package kr.or.ddit.staff.service;

import java.util.List;

import kr.or.ddit.staff.model.EmpVo;
import kr.or.ddit.staff.repository.EmpDao;
import kr.or.ddit.staff.repository.EmpDaoI;

public class EmpService implements EmpServiceI{
	
	EmpDaoI empdao = new EmpDao();

	// 모든 직원 정보를 가져오기
	@Override
	public List<EmpVo> selectAllEmp() {
		
		return empdao.selectAllEmp();
	}

}
