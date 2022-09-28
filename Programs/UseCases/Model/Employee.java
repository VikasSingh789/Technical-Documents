package com.practice.model;

public class Employee {
	
	private int empId;
	private String empName;
	private int deptid;
	private String status="active";
	private int doj;
	private int salary;
	private String gender;
	

	public Employee(int empId, String empName, int deptid, String status, int doj, int salary, String gender) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.deptid = deptid;
		this.status = status;
		this.doj = doj;
		this.salary = salary;
		this.gender = gender;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getDoj() {
		return doj;
	}

	public void setDoj(int doj) {
		this.doj = doj;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", deptid=" + deptid + ", status=" + status
				+ ", doj=" + doj + ", salary=" + salary + ", gender=" + gender + "]";
	}
	

}
