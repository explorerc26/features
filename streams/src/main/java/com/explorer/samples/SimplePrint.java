package com.explorer.samples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class SimplePrint {

	public static void main(String[] args) {
		
		@SuppressWarnings("serial")
		List<String> items = new ArrayList<String>() {{
		    add("item1");add("item2");add("item3");
		    add("item4");add("item5");add("item6");
		}};
		
		printCollectionSerial(items);
		printCollectionParallel(items);
		filterMapPrint(items);
 		


	}
	
	
	public static void filterMapPrint(Collection<String> items){
		
		items
	    .parallelStream()
	    .filter(s -> {
	        System.out.format("filter: %s [%s]\n",
	            s, Thread.currentThread().getName());
	        return true;
	    })
	    .map(s -> {
	        System.out.format("map: %s [%s]\n",
	            s, Thread.currentThread().getName());
	        return s.toUpperCase();
	    })
	    .forEach(s -> System.out.format("forEach: %s [%s]\n",
	        s, Thread.currentThread().getName()));
		
		
	}
	
	public static void printCollectionSerial(Collection<String> items){
		System.out.println(" -- Going to print the items --");
		items.stream().forEach(item -> {
						System.out.format("%s [%s]\n",
									item, Thread.currentThread().getName());
									});
		System.out.println(" -- done printing -- ");
	}
	
	public static void printCollectionParallel(Collection<String> items){
		System.out.println(" -- Going to print the items --");
		items.parallelStream().forEach(item -> {
						System.out.format("%s [%s]\n",
									item, Thread.currentThread().getName());
									});
		System.out.println(" -- done printing -- ");
	}

}
