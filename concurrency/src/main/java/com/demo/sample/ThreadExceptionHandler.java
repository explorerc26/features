package com.demo.sample;

public class ThreadExceptionHandler {


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
					throw new RuntimeException("Random Exception");
				}
				Thread.sleep(5000);
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
		
		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
		    public void uncaughtException(Thread t, Throwable e) {
		    	System.out.println("Thread:" +t.getId() + " got exception, message:"+e.getMessage() );
		    }
		 });
		
		t1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
		    public void uncaughtException(Thread t, Throwable e) {
		    	System.out.println("This is from thread exception handler : Thread:" +t.getId() + " got exception, message:"+e.getMessage() );
		    	if (true)
		    		throw new RuntimeException("from thread exception handler : Random Exception");
		    	
		    }
		 });
		
		t1.start();
		t2.start();
		try {
			t1.join();
			System.out.println("Done t1");
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("done main");
	}

}
