package com.demo.sample.concurrency.locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
	private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

	private static String message = "";

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Read());
		Thread t2 = new Thread(new WriteA());
		Thread t3 = new Thread(new WriteB());
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
	}

	static class Read implements Runnable {

		public void run() {
			for (int i = 0; i <= 10; i++) {
				lock.readLock().lock();
				System.out.println("ReadThread " + Thread.currentThread().getId() + " Message is :" + message);
				lock.readLock().unlock();
			}
		}
	}

	static class WriteA implements Runnable {

		public void run() {
			for (int i = 0; i <= 10; i++) {
				try {
					lock.writeLock().lock();
					message = message.concat("[A"+i+"]");
				} finally {
					lock.writeLock().unlock();
				}
			}
		}
	}

	static class WriteB implements Runnable {

		public void run() {
			for (int i = 0; i <= 10; i++) {
				try {
					lock.writeLock().lock();
					message = message.concat("[B"+i+"]");
				} finally {
					lock.writeLock().unlock();
				}
			}
		}
	}
}