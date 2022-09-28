package com.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.practice.model.Employee;

public class StreamsLogical {

	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(101, "Adam", 101, "active", 2011, 20000, "M"));
		employees.add(new Employee(102, "Brock", 101, "active", 2015, 50000, "F"));
		employees.add(new Employee(103, "Charlie", 102, "inactive", 2012, 60000, "M"));
		employees.add(new Employee(104, "David", 102, "inactive", 2013, 40000, "F"));
		employees.add(new Employee(105, "Ekris", 103, "active", 2016, 35000, "M"));
		employees.add(new Employee(106, "Freddie", 103, "inactive", 2017, 35000, "M"));
		employees.add(new Employee(107, "Gosh", 104, "active", 2014, 35000, "F"));
		employees.add(new Employee(108, "Harry", 102, "active", 2013, 35000, "M"));
		
		
		//WAP to print Employee details working in each Department
		System.out.println("WAP to print Employee details working in each Department");
		Map<Integer, List<Employee>> empDetails = employees.stream().collect(Collectors.groupingBy(Employee::getDeptid, Collectors.toList()));
		empDetails.entrySet().forEach(empDetail->{
			System.out.println("DeptId: "+empDetail.getKey()+" contains "+ empDetail.getValue());
		});
		
		//OR
		System.out.println("-------------------------------");
		
		empDetails.entrySet().forEach(empDetail->{
			System.out.print("DeptId: "+empDetail.getKey()+" contains ");
			List<Employee> listOfEmployee = empDetail.getValue();
			for (Employee employee : listOfEmployee) {
				System.out.print(employee.getEmpId()+" "+employee.getEmpName()+" ");
			}
			System.out.println();
		});
		
		
		//WAP to print Employees count working in each Department
		System.out.println();
		System.out.println("WAP to print Employee details working in each Department");
		Map<Integer, Long> employeeCounts = employees.stream().collect(Collectors.groupingBy(Employee::getDeptid, Collectors.counting()));
		employeeCounts.entrySet().forEach(employeeCount->{
			System.out.println("In DeptID:"+employeeCount.getKey()+" Contains "+employeeCount.getValue()+" Employees");
		});
		
		
		//WAP to print active and Inactive employees in given Collection
		System.out.println();
		System.out.println("WAP to print active and Inactive employees in given Collection");
		employees.stream().filter(emp->"inactive".equals(emp.getStatus())).forEach(System.out::println);
		
		//OR
		System.out.println("-------------------------------");
		
		List<Employee> listOfEmployees = employees.stream().filter(emp->"inactive".equals(emp.getStatus())).collect(Collectors.toList());
		for (Employee employee : listOfEmployees) {
			System.out.println(employee.getEmpId()+" "+employee.getEmpName());
		}
		
		
		//WAP to print Max/Min Employee Salary in given Collection
		System.out.println();
		System.out.println("WAP to print Max/Min Employee Salary in given Collection");
		Optional<Employee> emp1 = employees.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
		System.out.println(emp1.get().getEmpName()+" "+emp1.get().getSalary());
		
		//OR
		System.out.println("-------------------------------");
		
		Optional<Employee> emp2 = employees.stream().max(Comparator.comparing(Employee::getSalary));
		System.out.println(emp2.get().getEmpName()+" "+emp2.get().getSalary());
		
		
		//WAP to print Max/Min Employee Salary from each Department
		System.out.println();
		System.out.println("WAP to print Max/Min Employee Salary from each Department");
		Map<Integer, Optional<Employee>> empSalDept =
				employees.stream().
						collect(Collectors.groupingBy(
							Employee::getDeptid, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		
		empSalDept.entrySet().forEach(esd->{
			System.out.println(esd.getKey()+" "+esd.getValue().get().getEmpName()+":"+esd.getValue().get().getSalary());
		});
		
		
		//How many male and female employees are there in the organization?
		System.out.println();
		System.out.println("How many male and female employees are there in the organization");
		Map<String, Long> countOfMFs = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		countOfMFs.entrySet().forEach(countOfMF->{
			System.out.println(countOfMF.getKey()+" "+countOfMF.getValue());
		});
		
		
		//Print the number of all departments in the organization
		System.out.println();
		System.out.println("Print the number of all departments in the organization");
		employees.stream().map(Employee::getDeptid).forEach(System.out::println);
		
		
		//What is the average Salary of male and female employees
		System.out.println();
		System.out.println("What is the average Salary of male and female employees");
		Map<String, Double> avgSal = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getSalary)));
		avgSal.entrySet().forEach(sal->{
			System.out.println(sal.getKey()+" "+sal.getValue());
		});
		
		
		//Get the details of highest paid employee in the organization
		System.out.println();
		System.out.println("Get the details of highest paid employee in the organization");
		Optional<Employee> highestSal = employees.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
		System.out.println(highestSal.get().getSalary()+" "+highestSal.get().getEmpName());
		
		
		//Get the names of all employees who have joined after 2015
		System.out.println();
		System.out.println("Get the names of all employees who have joined after 2015");
		employees.stream().filter(emp->emp.getDoj()>2015).map(Employee::getEmpName).forEach(System.out::println);
		
		
		//Count the number of employees in each department
		System.out.println();
		System.out.println("Count the number of employees in each department");
		Map<Integer, Long> countOfEmployees = employees.stream().collect(Collectors.groupingBy(Employee::getDeptid, Collectors.counting()));
		countOfEmployees.entrySet().forEach(countOfEmployee->{
			System.out.println(countOfEmployee.getKey()+" "+countOfEmployee.getValue());
		});
		
		
		//What is the average salary of each department
		System.out.println();
		System.out.println("What is the average salary of each department");
		Map<Integer, Double> empAvgSal = employees.stream().collect(Collectors.groupingBy(Employee::getDeptid, Collectors.averagingDouble(
													Employee::getSalary)));
		empAvgSal.entrySet().forEach(avgsal->{
			System.out.println(avgsal.getKey()+" "+avgsal.getValue());
		});
		
		
		//Get the details of recent joined male employee from 102 department
		System.out.println();
		System.out.println("Get the details of recent joined male employee from 102 department");
		Optional<Employee> recentJoined = employees.stream().filter(emp->emp.getDeptid() == 102 && emp.getGender()=="M").collect(
				Collectors.maxBy(Comparator.comparing(
						Employee::getDoj)));
		System.out.println(recentJoined.get().getEmpName()+" "+recentJoined.get().getDoj());
	}

}
