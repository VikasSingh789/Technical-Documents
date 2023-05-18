package com.practice;

import java.util.ArrayList;
import java.util.List;

interface i1{
	default void m1() {
		System.out.println("Default method i1 interface");
	}
	
}

interface i2{
	default void m1() {
		System.out.println("Default method i2 interface");
	}
	
}

class Department{
	
	public int deptId;
	public String deptName;
	public List<Employee> listOfEmployees;
	
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public List<Employee> getListOfEmployees() {
		return listOfEmployees;
	}
	public void setListOfEmployees(List<Employee> listOfEmployees) {
		this.listOfEmployees = listOfEmployees;
	}
	public Department(int deptId, String deptName, List<Employee> listOfEmployees) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.listOfEmployees = listOfEmployees;
	}
	
	
}

class Employee{
	public int empId;
	public String empName;
	public int empSalary;
	
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
	public int getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}
	
	public Employee(int empId, String empName, int empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}
	
	
}

public class DepartmentAndEmployee implements i1,i2 {
	
	@Override
	public void m1() {
		i1.super.m1();
		i2.super.m1();
	}

	public static void main(String[] args) {
		
		Employee emp1 = new Employee(1, "vikas", 20000);
		Employee emp2 = new Employee(2, "akash", 3000);
		
		List<Employee> listOfEmployees = new ArrayList();
		listOfEmployees.add(emp1);
		listOfEmployees.add(emp2);
		
		Department d1 = new Department(1, "deptName1", listOfEmployees);
		Department d2 = new Department(2, "deptName2", listOfEmployees);
		
		List<Employee> empl = d1.getListOfEmployees();
		empl.stream().filter(n->n.getEmpSalary()<=3000).map(n->n.getEmpName()+" "+d1.deptName).forEach(System.out::println);
		
		List<Department> listOfDepartments = new ArrayList();
		listOfDepartments.add(d1);
		listOfDepartments.add(d2);
		System.out.println("--------------");
		
		for(Department d:listOfDepartments) {
			List<Employee> emp = d.getListOfEmployees();
			emp.stream().filter(n->n.getEmpSalary()<=3000 && d.getDeptId()==2).forEach(n->System.out.println(n.getEmpName()+" "+d.deptName));
		}
		
		listOfEmployees.stream().filter(n->n.getEmpName().startsWith("v")).forEach(n->System.out.println(n.getEmpName()));
		
		
		DepartmentAndEmployee dae = new DepartmentAndEmployee();
		dae.m1();
		
	}

}
