package com.demo.sample;

import com.demo.sample.model.Counter;

public class InterferenceDemo implements Runnable{
	
	private Counter counter; 
	
	public InterferenceDemo(Counter counter){
		this.setCounter(counter);
	}
	

	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();
		Thread thread1 = new Thread(new InterferenceDemo(counter));
		Thread thread2 = new Thread(new InterferenceDemo(counter));
		Thread thread3 = new Thread(new InterferenceDemo(counter));
		Thread thread4 = new Thread(new InterferenceDemo(counter));
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		thread1.join();
		thread2.join();
		thread3.join();
		thread4.join();
		
		System.out.println("count "+ counter.value());
	}

	@Override
	public void run() {
		for(int i = 0 ; i < 10000 ; i++){
			counter.increment();
			counter.decrement();
			counter.increment();
			counter.decrement();
		}
		System.out.println("Done");
	}


	public Counter getCounter() {
		return counter;
	}


	public void setCounter(Counter counter) {
		this.counter = counter;
	}

}
