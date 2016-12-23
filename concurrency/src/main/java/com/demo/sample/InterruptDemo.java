package com.demo.sample;

public class InterruptDemo implements Runnable {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new InterruptDemo());
		t1.start();
		Thread.sleep(1000); // interrupt the thread
		t1.interrupt();
	}

	@Override
	public void run() {
		print("started");
		print("started waiting");
		boolean indicator = true;
		while(indicator){
			if(Thread.currentThread().isInterrupted()){ // simple check interrupt status - wont clear the interrupt flag
				indicator = false;
				print("Interrupted");
			}
		}
		System.out.println("Interrupt status "+Thread.currentThread().isInterrupted()); // still interrupt flag is on
		print("returning ..");
		
		try {
			Thread.sleep(4000); // ohh boy - it wont wait - still interrupt flag is there
			print(" sucessfuly waited for 4 secs");
		} catch (InterruptedException e) { // clears interrupt by convention
			print(" No wait here -- immediately comes out");
		}
		
		try {
			Thread.sleep(2000); // no interrupt - it will wait 
			print(" sucessfuly waited for 2 secs");
		} catch (InterruptedException e) { // nope it wont come here
			print("it wont print this : No wait here -- immediately comes out");
		}
		Thread.interrupted();// clears interrupt 
	}

	public static void print(String msg) {
		System.out.println("Thread"+Thread.currentThread().getId() + " - " + msg);
	}
}
