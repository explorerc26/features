package com.demo.sample.concurrency.utility;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

import com.demo.sample.ThreadUtil;

public class SemaphoreDemo {

	public static class Worker implements Runnable {
		public Worker(Semaphore semaphore) {
			this.semaphore = semaphore;
		}

		private Semaphore semaphore;

		@Override
		public void run() {
			ThreadUtil.print("trying to aquire");
			try {
				semaphore.acquire();
//				semaphore.acquire();
//				semaphore.acquire();
//				semaphore.acquire();
//				semaphore.acquire();
				//Q: not reentrant
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ThreadUtil.print("aquired");
			ThreadUtil.randomWait();
			ThreadUtil.print("Done execution - going to releae");
			semaphore.release();
			semaphore.release();
			semaphore.release();
			semaphore.release();
			semaphore.release();
			semaphore.release();
			ThreadUtil.print("permits"+semaphore.availablePermits());
			//Q: semaphores have no notion of ownership
		}

	}

	public static void main(String[] args) throws InterruptedException {

		Semaphore twoAtAtime = new Semaphore(2);

		IntStream.range(0, 6).forEach(i -> {
			Thread thread = new Thread(new Worker(twoAtAtime), Integer.toString(i));
			thread.start();
		});
		System.out.println("done main");

	}
}