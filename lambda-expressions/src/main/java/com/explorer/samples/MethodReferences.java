package com.explorer.samples;

import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

public class MethodReferences {
	
	public class SimpleUtil{
		public int compareByNameGeneral(Person p1, Person p2) {
			return p1.getLastName().compareTo(p2.getLastName());
		}
	}
	
	public static void main(String... args) {
		
		// normal way 
		List<Person> persons = Person.getRandomPeople();
		//print
		persons.stream().forEach(s->System.out.println(s));
		
		persons.sort(new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.getLastName().compareTo(p2.getLastName());
			}
		});
		System.out.println("after sorting normal way");
		persons.stream().forEach(s->System.out.print(s.getId()+" "));
		System.out.println("\n");
		// lambdas
		persons = Person.getRandomPeople();
		persons.sort((p1,p2)-> {return p1.getLastName().compareTo(p2.getLastName());});
		System.out.println("after sorting lambdas way");
		persons.stream().forEach(s->System.out.print(s.getId()+" "));
		System.out.println("\n");
		
		// method references
		//Reference to a static method	
		//ContainingClass::staticMethodName
		persons = Person.getRandomPeople();
		persons.sort(Person::compareByNameStatic);
		System.out.println("method references");
		persons.stream().forEach(s->System.out.print(s.getId()+" "));
		System.out.println("\n");
	
		// method references
		//Reference to an instance method of a particular object	
		//containingObject::instanceMethodName
		MethodReferences methodRefExample = new MethodReferences();
		SimpleUtil personCompareUtil = methodRefExample.new SimpleUtil();
		persons = Person.getRandomPeople();
		persons.sort(personCompareUtil::compareByNameGeneral);
		System.out.println("method references");
		persons.stream().forEach(s->System.out.print(s.getId()+" "));
		System.out.println("\n");	
		
		
		// method references
		//Reference to an instance method of an arbitrary object of a particular type	
		//ContainingType::methodName
		persons = Person.getRandomPeople();
		persons.sort(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName));
		System.out.println("method references");
		persons.stream().forEach(s->System.out.print(s.getId()+" "));
		System.out.println("\n");
		
		
		Supplier<MethodReferences> supplier = MethodReferences::new;
	    System.out.println(supplier.get());
	}
	
	

}
