package com.demo.sample.concurrency.utility;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

import com.demo.sample.ThreadUtil;

public class CountDownLatchDemo {

	public static class Worker implements Runnable {
		public Worker(CountDownLatch countDownLatch) {
			this.countDownLatch = countDownLatch;
		}

		CountDownLatch countDownLatch;

		@Override
		public void run() {
			ThreadUtil.print("going to wait");
			ThreadUtil.randomWait();
			countDownLatch.countDown();
			ThreadUtil.print("Done");
		}

	}

	public static void main(String[] args) throws InterruptedException {

		CountDownLatch countDownLatch = new CountDownLatch(5);

		IntStream.range(0, 5).forEach(i -> {
			Thread thread = new Thread(new Worker(countDownLatch), Integer.toString(i));
			thread.start();
		});
		countDownLatch.await();
		System.out.println("done main");

	}
}