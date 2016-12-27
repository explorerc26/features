package com.demo.sample;

import com.demo.sample.model.Monitor;

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
