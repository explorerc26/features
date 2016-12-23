package com.demo.sample;

public class SimpleExtendedThread extends Thread {

	public SimpleExtendedThread(){
		
	}
	
	public SimpleExtendedThread(String name){
		super(name);
	}

	public static void main(String[] args) {
		System.out.println("Available no of processors "+ Runtime.getRuntime().availableProcessors());

		//The reason is that java.lang.Runtime.availableProcessors() is returning the
		//number of logical processors, rather than the physical ones.
		//http://bugs.java.com/bugdatabase/view_bug.do?bug_id=5048379
		//http://blog.quibb.org/2010/03/jsr-166-the-java-forkjoin-framework/
		//https://en.wikipedia.org/wiki/Green_threads
		(new SimpleExtendedThread()).start();
		(new SimpleExtendedThread("SimpleThread")).start();
	}

	public void run() {
		System.out.println("Hello from a thread! - "+Thread.currentThread().getName());
	}

}
