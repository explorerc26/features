package com.demo.sample;

public class SynchronizedException {


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

	
	public static class Printer{
		
		public static boolean flag = true;
		
		public synchronized void  print(){
			try {
				System.out.println("Thread:" + Thread.currentThread().getId() + " - messgae 1");
				Thread.sleep(1000);
				System.out.println("Thread:" + Thread.currentThread().getId() + " - messgae 2");
				if(flag){
					flag = false;
					throw new RuntimeException();
				}
				Thread.sleep(10000);
				System.out.println("Thread:" + Thread.currentThread().getId() + " - messgae 3");
				System.out.println("Thread:" + Thread.currentThread().getId() + " - done executing");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
	
	public static void main(String[] args) {
		Printer p = new Printer();
		Thread t1 = new Thread(new Sample(p), "guineapig");
		Thread t2 = new Thread(new Sample(p));
		t1.start();
		t2.start();
		try {
			t1.join();
			System.out.println("no excpetion or interrupt");
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		//Q: exception is in thread t1 - it will not reach main thread
		System.out.println("t1 state "+t1.getState());
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("done main");
	}

}
