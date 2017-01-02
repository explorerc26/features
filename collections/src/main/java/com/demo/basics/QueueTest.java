package com.demo.basics;

import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue<String> queue = new BasicLinkedListQueue<String>();
		queue.add("hello");
		System.out.println(queue.remove());
	}

}
