package com.demo.sample;

public class ThreadLocalDemo {

	public static class Sample implements Runnable {

		private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
		private ThreadLocal<Integer> threadLocalWithInitialValue = new ThreadLocal<Integer>() {
			@Override
			protected Integer initialValue() {
				return -1;
			}
		};
		private InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<String>();

		public ThreadLocal<Integer> getThreadLocal() {
			return threadLocal;
		}

		public InheritableThreadLocal<String> getInheritableThreadLocal() {
			return inheritableThreadLocal;
		}

		public ThreadLocal<Integer> getThreadLocalWithInitialValue() {
			return threadLocalWithInitialValue;
		}

		@Override
		public void run() {
			int value = (int) (Math.random() * 10);
			System.out.println(Thread.currentThread().getName() + " ThreadLocal existing value=" + threadLocal.get());
			System.out.println(Thread.currentThread().getName() + " ThreadLocal going to set value=" + value);
			System.out.println(Thread.currentThread().getName() + " threadLocalWithInitialValue existing value=" + threadLocalWithInitialValue.get());
			
			threadLocal.set(value);
			threadLocalWithInitialValue.set(value);

			if (Thread.currentThread().getName().equals("thread1")) {
				System.out.println(Thread.currentThread().getName() + " inheritableThreadLocal existing value="
						+ inheritableThreadLocal.get());
				System.out.println(
						Thread.currentThread().getName() + " inheritableThreadLocal going to set name=thread1");
				inheritableThreadLocal.set("thread1");
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			System.out.println(Thread.currentThread().getName() + " ThreadLocal new value=" + threadLocal.get());
			System.out.println(Thread.currentThread().getName() + " inheritableThreadLocal new value="
					+ inheritableThreadLocal.get());
			System.out.println(Thread.currentThread().getName() + " threadLocalWithInitialValue new value=" + threadLocalWithInitialValue.get());
		}

	}

	public static void main(String[] args) throws InterruptedException {
		Sample sample = new Sample();
		int value = 1000;
		String name = "main";
		System.out.println(
				Thread.currentThread().getName() + " ThreadLocal existing value=" + sample.getThreadLocal().get());
		System.out.println(Thread.currentThread().getName() + " ThreadLocal going to set value=" + value);
		sample.getThreadLocal().set(value);

		System.out.println(Thread.currentThread().getName() + " inheritableThreadLocal existing value="
				+ sample.getInheritableThreadLocal().get());
		System.out.println(Thread.currentThread().getName() + " inheritableThreadLocal going to set value=" + name);
		sample.getInheritableThreadLocal().set(name);

		Thread thread1 = new Thread(sample);
		thread1.setName("thread1");
		Thread thread2 = new Thread(sample);
		thread2.setName("thread2");

		thread1.start();
		thread2.start();

		thread1.join(); // wait for thread 1 to terminate
		thread2.join(); // wait for thread 2 to terminate
		System.out.println(Thread.currentThread().getName() + " ThreadLocal value=" + sample.getThreadLocal().get());
		System.out.println(Thread.currentThread().getName() + " inheritableThreadLocal value="
				+ sample.getInheritableThreadLocal().get());
		System.out.println("Each thread has its own thread local varianle");
	}

}