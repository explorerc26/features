package com.demo.sample;

import java.lang.Thread.State;

public class ThreadStateDemo {

	public static class Sample implements Runnable {

		public Sample(Printer printer) {
			super();
			this.printer = printer;
		}

		Printer printer;
		
		@Override
		public void run() {
			printer.print();
		}
		
	}
	
	public static class ThreadStatusMonitor implements Runnable {

		public ThreadStatusMonitor(Thread thread) {
			this.thread = thread;
		}
		Thread thread ;
		
		@Override
		public void run() {
			State prev = null ;  
			while(!Thread.currentThread().isInterrupted()){
				State cur = thread.getState();
				if (prev != cur) {
					System.out.println("Monitor:" + Thread.currentThread().getId() + " state " + cur);
					prev = cur;
				}
				
			}
			
		}
		
	}
	
	
	public static class Printer{
		
		public synchronized void  print(){
			try {
				System.out.println("Thread:" + Thread.currentThread().getId() + " - messgae 1");
				Thread.sleep(1000);
				System.out.println("Thread:" + Thread.currentThread().getId() + " - messgae 2");
				Thread.sleep(1000);
				System.out.println("Thread:" + Thread.currentThread().getId() + " - messgae 3");
				System.out.println("Thread:" + Thread.currentThread().getId() + " - done executing");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
	
	public static void main(String[] args) {
		Printer p = new Printer();
		Thread t = new Thread(new Sample(p));
		Thread monitor = new Thread(new ThreadStatusMonitor(t));
		monitor.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		t.start();
		//Q:t1.start(); - throws java.lang.IllegalThreadStateException cannot start more than once
		try {
			System.out.println(" Thread status "+t.getState());
			t.join();
			System.out.println("thread 1 is done");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}	
		monitor.interrupt();
		try {
			monitor.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Q:t1.start(); - throws  java.lang.IllegalThreadStateException - thread is gone -you can start
	}

}
