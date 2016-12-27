package com.demo.sample;

public class SimpleLock {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Lock lock = new Lock();
		Thread t1 = new Thread(new Locker(lock));
		Thread t2 = new Thread(new UnLocker(lock));
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
	}
	
	public static class Locker implements Runnable {
		private Lock lock; 
		
		public Locker(Lock lock){
			this.lock = lock;
		}

		@Override
		public void run() {
			try {
				lock.lock(0);
				lock.lock(1);
				lock.lock(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static class UnLocker implements Runnable {
		private Lock lock; 
		
		public UnLocker(Lock lock){
			this.lock = lock;
		}
		@Override
		public void run() {
			try {
				Thread.currentThread().sleep(1000);
				lock.unlock();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	public static class Lock {

		private boolean isLocked = false;

		public synchronized void lock(int value) throws InterruptedException {
			ThreadUtil.print("inside synchronised "+value);
			while (isLocked) {
				ThreadUtil.print("going to wait "+value);
				wait();
				ThreadUtil.print("came out of wait "+value);
			}
			isLocked = true;
		}

		public synchronized void unlock() {
			ThreadUtil.print("unlocking");
			isLocked = false;
			notify();
		}
	}
}
