package com.demo.sample;

public class SimpleExtendedThread extends Thread {

	public static void main(String[] args) {
		(new SimpleExtendedThread()).start();
	}

	public void run() {
		System.out.println("Hello from a thread!");
	}

}
