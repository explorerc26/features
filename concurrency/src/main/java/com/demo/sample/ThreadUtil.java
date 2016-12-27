package com.demo.sample;

public class ThreadUtil {
	public static void print(String msg) {
		System.out.println("Thread:" + Thread.currentThread().getId() + " - " + msg);
	}
}
