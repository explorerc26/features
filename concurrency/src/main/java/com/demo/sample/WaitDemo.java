package com.demo.sample;

import com.demo.sample.model.Monitor;

/**
 * wait should be in synchronized - sleep need not be 
 * wait will give away locks - sleep will hold it 
 * need notify or notifyall for the waitiung thread to come out - sleep after timeout 
 * notify or notify call should be called in synchronized block and after completing 
 * the execution , the eligible waiting thread will start running if it gets back the lock
 * 
 * 
 *.sleep(n) says “I’m done with my timeslice, and please don’t give me another one for at least n milliseconds.” The OS doesn’t even try to schedule the sleeping thread until requested time has passed.
 *.yield() says “I’m done with my timeslice, but I still have work to do.” The OS is free to immediately give the thread another timeslice, or to give some other thread or process the CPU the yielding thread just gave up.
 *.wait() says “I’m done with my timeslice. Don’t give me another timeslice until someone calls notify().” 
 * 
 *Thread.sleep() from a synchronized block is likely not a good idea.
 */
public class WaitDemo {

	public static class Sample implements Runnable {

		private Monitor monitor;

		public Sample(Monitor monitor) {
			this.monitor = monitor;
		}

		@Override
		public void run() {
			ThreadUtil.print("started ");
			// below code is synchronized - so one after the other will execute
			synchronized (monitor) {
				ThreadUtil.print("going to sleep for 1 sec");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ThreadUtil.print("came out of sleep");
				ThreadUtil.print("going to wait");
				try {
					monitor.wait();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				ThreadUtil.print("came out of wait");
				ThreadUtil.print("going to sleep for one more sec");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ThreadUtil.print("done executing");

			}

		}

	}

	public static void main(String... args) throws InterruptedException {
		Monitor monitor = new Monitor();
		Thread thread1 = new Thread(new Sample(monitor));
		Thread thread2 = new Thread(new Sample(monitor));
		Thread thread3 = new Thread(new Sample(monitor));
		thread1.start();
		thread2.start();
		thread3.start();
		Thread.sleep(10000);
//		synchronized (monitor) {
//			monitor.notifyAll();
//		}
		
		synchronized (monitor) {
			monitor.notify();
		}

		thread1.join();
		thread2.join();
		thread3.join();
	}
}
