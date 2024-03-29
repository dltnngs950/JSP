package kr.or.ddit.staff.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EmpVo {
	
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private String sal;
	private int comm;
	private int deptno;
	
	private EmpVo() {}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	
	public String getHiredate_sdf() {
		
		if(this.hiredate == null) {
			return "";
		}else {
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY.MM.dd");
			return sdf.format(this.hiredate);
		}
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "EmpVo [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate=" + hiredate
				+ ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}
	
	

}
