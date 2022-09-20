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
		employees.add(new Employee(101, "Adam", 101, "active", 20000));
		employees.add(new Employee(102, "Brock", 101, "active", 50000));
		employees.add(new Employee(103, "Charlie", 102, "inactive", 60000));
		employees.add(new Employee(104, "David", 102, "inactive", 40000));
		employees.add(new Employee(105, "Ekris", 103, "active", 35000));
		employees.add(new Employee(106, "Freddie", 103, "inactive", 35000));
		employees.add(new Employee(107, "Gosh", 104, "active", 35000));
		
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
		
		
		System.out.println();
		//WAP to print Employees count working in each Department
		System.out.println("WAP to print Employee details working in each Department");
		Map<Integer, Long> employeeCounts = employees.stream().collect(Collectors.groupingBy(Employee::getDeptid, Collectors.counting()));
		employeeCounts.entrySet().forEach(employeeCount->{
			System.out.println("In DeptID:"+employeeCount.getKey()+" Contains "+employeeCount.getValue()+" Employees");
		});
		
		
		System.out.println();
		//WAP to print active and Inactive employees in given Collection
		System.out.println("WAP to print active and Inactive employees in given Collection");
		employees.stream().filter(emp->"inactive".equals(emp.getStatus())).forEach(System.out::println);
		
		//OR
		System.out.println("-------------------------------");
		
		List<Employee> listOfEmployees = employees.stream().filter(emp->"inactive".equals(emp.getStatus())).collect(Collectors.toList());
		for (Employee employee : listOfEmployees) {
			System.out.println(employee.getEmpId()+" "+employee.getEmpName());
		}
		
		
		System.out.println();
		//WAP to print Max/Min Employee Salary in given Collection
		System.out.println("WAP to print Max/Min Employee Salary in given Collection");
		Optional<Employee> emp1 = employees.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
		System.out.println(emp1.get().getEmpName()+" "+emp1.get().getSalary());
		
		//OR
		System.out.println("-------------------------------");
		
		Optional<Employee> emp2 = employees.stream().max(Comparator.comparing(Employee::getSalary));
		System.out.println(emp2.get().getEmpName()+" "+emp2.get().getSalary());
		
		
		System.out.println();
		//WAP to print Max/Min Employee Salary from each Department
		System.out.println("WAP to print Max/Min Employee Salary from each Department");
		Map<Integer, Optional<Employee>> empSalDept =
				employees.stream().
						collect(Collectors.groupingBy(
							Employee::getDeptid, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		
		empSalDept.entrySet().forEach(esd->{
			System.out.println(esd.getKey()+" "+esd.getValue().get().getEmpName()+":"+esd.getValue().get().getSalary());
		});
	}

}
