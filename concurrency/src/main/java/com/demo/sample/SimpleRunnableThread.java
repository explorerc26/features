package com.demo.sample;

public class SimpleRunnableThread implements Runnable{

	public static void main(String[] args) {
		new Thread (new SimpleRunnableThread()).start();
		new Thread (new SimpleRunnableThread(), "SimpleThread").start();
	}

	@Override
	public void run() {
		 System.out.println("Hello from a thread! - "+Thread.currentThread().getName());
	}

}
