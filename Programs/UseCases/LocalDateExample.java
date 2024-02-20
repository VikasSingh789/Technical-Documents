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

	public static void withJava7(List<LocalDateExample> list) {
		LocalDate now = LocalDate.now();
		list.forEach(n->{
			Period p = Period.between(n.getDob(), now);
			int ageDiff = p.getYears();
			if(ageDiff>=25 && ageDiff<=40) {
				System.out.println(n.getName());
			}
		});
	}
	
	public static void withStreams(List<LocalDateExample> list) {
		List<LocalDateExample> listOfAge = list.stream().filter(n-> LocalDateExample.checkAgeDifference(n.getDob(), LocalDate.now(), 25, 40) == true).collect(Collectors.toList());
		listOfAge.forEach(n->System.out.println(n.getName()));
		System.out.println("Without Collecting the Results:-");
		list.stream().filter(n-> LocalDateExample.checkAgeDifference(n.getDob(), LocalDate.now(), 25, 40) == true).forEach(n->System.out.println(n.getName()));
	}
	
	public static boolean checkAgeDifference(LocalDate d1, LocalDate d2, int startRange, int endRange) {
		int diffAge = Period.between(d1, d2).getYears();
		if (diffAge >= startRange && diffAge <= endRange) {
			return true;
		}
		return false;
	}


	public static void main(String[] args) {
		LocalDateExample l1 = new LocalDateExample(1L, "vikas", LocalDate.of(1991, 01, 01));
		LocalDateExample l2 = new LocalDateExample(2L, "vivek", LocalDate.of(1999, 11, 29));
		LocalDateExample l3 = new LocalDateExample(3L, "abc", LocalDate.of(1987, 11, 29));

		List<LocalDateExample> list = Arrays.asList(l1, l2, l3);
		withJava7(list);
		withStreams(list);


		LocalDateTime l = LocalDateTime.now();
		System.out.println(l);
		DateTimeFormatter d = DateTimeFormatter.ofPattern("dd M yy:m h s");
		String n = d.format(l);
		System.out.println(n);
		System.out.println(n.substring(3,4));

	}

}
