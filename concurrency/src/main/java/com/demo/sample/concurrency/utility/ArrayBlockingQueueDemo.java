package com.demo.sample.concurrency.utility;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.demo.sample.ThreadUtil;

public class ArrayBlockingQueueDemo {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);
		Thread thread1 = new Thread(new Producer(queue));
		Thread thread2 = new Thread(new Consumer(queue));
		
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
	}

	public static class Producer implements Runnable {

		private BlockingQueue<String> queue;

		Producer(BlockingQueue<String> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			try {
				for (int i = 0; i < 10; i++) {
					queue.put("item " + i);
					ThreadUtil.print("added item " + i);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	public static class Consumer implements Runnable {

		private BlockingQueue<String> queue;

		Consumer(BlockingQueue<String> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			try {
				for (int i = 0; i < 10; i++) {
					Thread.sleep(1000);
					ThreadUtil.print("got "+queue.take());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
