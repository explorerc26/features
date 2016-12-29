package com.demo.sample;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadUtil {
	public static void print(String msg) {
		System.out.println("Thread:" + Thread.currentThread().getId() + " - " + msg);
	}
	
	public static void randomWait() {
		try {
			int wait = 1+ThreadLocalRandom.current().nextInt(4);
			print("going to wait "+wait);
			Thread.sleep(wait *1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
