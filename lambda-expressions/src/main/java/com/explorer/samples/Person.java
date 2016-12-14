package com.explorer.samples;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Person {


	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", gender="
				+ gender + ", email=" + email + ", salary=" + salary + "]";
	}
	
	public Person(){
		
	}

	public Person(int id , String firstName, String lastName, LocalDate dob, Sex gender, String email, BigDecimal salary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.salary = salary;
	}
	private int id;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private Sex gender;
	private String email;
	private BigDecimal salary;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Sex getGender() {
		return gender;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public static int compareByNameStatic(Person p1, Person p2) {
		return p1.getLastName().compareTo(p2.getLastName());
	}
	
	public int compareByNameGeneral(Person p1, Person p2) {
		return p1.getLastName().compareTo(p2.getLastName());
	}
	
	public int compareByName(Person p){
		return this.getLastName().compareTo(p.getLastName());
	}

	
	public enum Sex{
		MALE,FEMALE
	}
	
	public static List<Person> getRandomPeople(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		List<Person> persons = new ArrayList<>();
		persons.add(new Person(1,"larry", "george", LocalDate.parse("03/02/1983", formatter), Sex.MALE, "abc1@def.com", new BigDecimal("5600")));
		persons.add(new Person(2,"tom", "wallace", LocalDate.parse("02/01/1982", formatter), Sex.MALE, "abc@2def.com", new BigDecimal("3400")));
		persons.add(new Person(3,"john", "rob", LocalDate.parse("01/04/1983", formatter), Sex.MALE, "absc@def.com", new BigDecimal("3000")));
		persons.add(new Person(4,"krish", "rob", LocalDate.parse("06/09/1984", formatter), Sex.MALE, "asbc@def.com", new BigDecimal("4500")));
		persons.add(new Person(5,"bob", "rob", LocalDate.parse("08/19/1985", formatter), Sex.MALE, "abdsc@dsaef.com", new BigDecimal("3000")));
		persons.add(new Person(6,"amy", "main", LocalDate.parse("03/16/1986", formatter), Sex.FEMALE, "absac@def.com", new BigDecimal("4000")));
		persons.add(new Person(7,"criste", "dot", LocalDate.parse("05/25/1989", formatter), Sex.FEMALE, "abdsac@dasdef.com", new BigDecimal("3000")));
		persons.add(new Person(8,"mary", "scot", LocalDate.parse("07/03/1986", formatter), Sex.FEMALE, "abc@deasdf.com", new BigDecimal("2200")));
		persons.add(new Person(9,"cindy", "moody", LocalDate.parse("07/07/1987", formatter), Sex.FEMALE, "aadssdabc@def.com", new BigDecimal("5600")));
		persons.add(new Person(10,"lara", "bot", LocalDate.parse("03/14/1988", formatter), Sex.FEMALE, "abc@deasdf.com", new BigDecimal("2300")));
		persons.add(new Person(11,"jenny", "scot", LocalDate.parse("02/21/1989", formatter), Sex.FEMALE, "abasdc@def.com", new BigDecimal("4500")));
		return persons;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
