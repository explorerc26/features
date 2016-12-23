package com.demo.sample;

import java.util.Random;

import com.demo.sample.model.Counter;

public class MemoryConsistencyErrorsDemo implements Runnable{

	private Counter counter; 
	
	public MemoryConsistencyErrorsDemo(Counter counter){
		this.setCounter(counter);
	}
	
	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();
		Thread thread1 = new Thread(new MemoryConsistencyErrorsDemo(counter));
		Thread thread2 = new Thread(new MemoryConsistencyErrorsDemo(counter));
		Thread thread3 = new Thread(new MemoryConsistencyErrorsDemo(counter));
		Thread thread4 = new Thread(new MemoryConsistencyErrorsDemo(counter));
		
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
		print("current value "+counter.value());
		counter.increment();
		print("value after increment "+counter.value());
		randomWait();
		counter.decrement();
		print("value after decrement "+counter.value());
		randomWait();
		counter.increment();
		print("value after increment "+counter.value());
		randomWait();
		print("value after decrement "+counter.value());
		print("value "+counter.value());
	}

	public Counter getCounter() {
		return counter;
	}

	public void setCounter(Counter counter) {
		this.counter = counter;
	}

	public static void print(String msg) {
		System.out.println("Thread"+Thread.currentThread().getId() + " - " + msg);
	}
	
	private void randomWait() {
		Random r = new Random();
		try {
			Thread.sleep(r.ints(0, (3 + 1)).limit(1).findFirst().getAsInt()*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
