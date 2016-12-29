package com.demo.sample.concurrency.utility;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

import com.demo.sample.ThreadUtil;

public class CyclicBarrierDemo {

	public static class Worker implements Runnable {
		public Worker(CyclicBarrier cyclicBarrier) {
			this.cyclicBarrier = cyclicBarrier;
		}

		CyclicBarrier cyclicBarrier;

		@Override
		public void run() {
			ThreadUtil.print("going to await");
			try {
				ThreadUtil.randomWait();
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
			ThreadUtil.print("came out of await");
		}

	}

	public static void main(String[] args) throws InterruptedException {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {

			@Override
			public void run() {
				ThreadUtil.print("will bring all the threads back online after 1 sec");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ThreadUtil.print("brining now");
			}

		});

		IntStream.range(0, 5).forEach(i -> {
			Thread thread = new Thread(new Worker(cyclicBarrier), Integer.toString(i));
			thread.start();
		});

		ThreadUtil.print(" End of main, cyclic barrier status " + cyclicBarrier.isBroken() + " waiting "
				+ cyclicBarrier.getNumberWaiting());
		Thread.sleep(6000);

		ThreadUtil.print(" End of main, cyclic barrier status " + cyclicBarrier.isBroken() + " waiting "
				+ cyclicBarrier.getNumberWaiting());

	}

}
