package com.programs;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;

public class LocalDateExample {

	public Long id;
	public String name;
	public LocalDate dob;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public LocalDateExample(Long id, String name, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}

	public static void main(String[] args) {
		LocalDateExample l1 = new LocalDateExample(1L,"vikas", LocalDate.of(1991, 01, 01));
		LocalDateExample l2 = new LocalDateExample(2L,"vivek", LocalDate.of(1999, 11, 29));
		
		List<LocalDateExample> list = Arrays.asList(l1,l2);
		LocalDate now = LocalDate.now();
		list.forEach(n->{
			Period p = Period.between(n.getDob(), now);
			int ageDiff = p.getYears();
			if(ageDiff>=25 && ageDiff<=35) {
				System.out.println(n.getName());
			}
		});
		
	}

}
