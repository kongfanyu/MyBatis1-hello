package com.shop.entity;

import java.util.Date;

public class Emp {

	private Integer id;
	private String ename;
	private Date hiredate;
	private String job;
	private Double sal;
	private Integer deptNo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		System.out.println("-----set方法=====");
		this.job = job;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public Integer getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", ename=" + ename + ", hiredate=" + hiredate + ", job=" + job + ", sal=" + sal
				+ ", deptNo=" + deptNo + "]";
	}
	public Emp(Integer id, String ename, Date hiredate, String job, Double sal, Integer deptNo) {
		super();
		this.id = id;
		this.ename = ename;
		this.hiredate = hiredate;
		this.job = job;
		this.sal = sal;
		this.deptNo = deptNo;
	}
	public Emp() {
		super();
	}
	
	
	
}
