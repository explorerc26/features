package com.explorer.samples;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Filtering {

	public static void main(String[] args) {
		List<Person> persons = getRandomPersons();

		persons.parallelStream().filter(s -> {
			if (s.sex == SEX.MALE)
				return true;
			else
				return false;
		}).forEach(s -> {
			System.out.println(s);
		});
		;
		
	}
	public static List<Person> getRandomPersons(){
		Filtering f = new Filtering();
		List<Person> persons  = new ArrayList<Person>();
		Random r = new Random();
		persons.add(f.new Person("rob",r.nextInt(100),SEX.MALE));
		persons.add(f.new Person("george",r.nextInt(100),SEX.MALE));
		persons.add(f.new Person("sam",r.nextInt(100),SEX.MALE));
		persons.add(f.new Person("linda",r.nextInt(100),SEX.FEMALE));
		persons.add(f.new Person("kathy",r.nextInt(100),SEX.FEMALE));
		persons.add(f.new Person("bob",r.nextInt(100),SEX.MALE));
		return persons; 
	}
	
	
	public class Person{
		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + ", sex=" + sex + "]";
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public SEX getSex() {
			return sex;
		}
		public void setSex(SEX sex) {
			this.sex = sex;
		}
		private String name;
		private int age ; 
		private SEX sex;
		
		Person(String name, int age, SEX sex){
			this.name= name; 
			this.age = age;
			this.sex = sex;
		}
		
	}
	
	public enum SEX{
		MALE,
		FEMALE
	}
	

}
