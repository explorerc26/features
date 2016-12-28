package com.demo.sample.executorService;

import java.sql.Timestamp;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import com.demo.sample.ThreadUtil;

public class ForkJoinAction {
	public static class WordPrinter extends RecursiveAction{
		private static final long serialVersionUID = 1L;

		public WordPrinter(int load) {
			this.load = load;
		}

		private int load;

		public int getLoad() {
			return load;
		}

		@Override
		protected void compute() {
			if(load > 2){
				System.out.println(Thread.currentThread().getName()+" going to divide "+load+" : "+new Timestamp(System.currentTimeMillis()));
				int mid = load/2;
				WordPrinter wordPrinter1 = new WordPrinter(mid);
				WordPrinter wordPrinter2 = new WordPrinter(load-mid);
				wordPrinter1.fork();
				wordPrinter2.fork();
				System.out.println(Thread.currentThread().getName()+" done "+load+" : "+new Timestamp(System.currentTimeMillis()));
//				List<WordPrinter> subtasks = new ArrayList<WordPrinter>();
//				subtasks.add(wordPrinter1);
//				subtasks.add(wordPrinter2);
//				for(WordPrinter task : subtasks){
//					task.fork();
//				}
			}else{
				for(int i = 0 ; i < load; i++)
				System.out.println(Thread.currentThread().getName()+" Hello World!!!"+load + " : "+new Timestamp(System.currentTimeMillis()));
			}
			
		}
	}
	
	public static void main(String ...args){
		WordPrinter wordPrinter = new WordPrinter(10);
		ForkJoinPool forkJoinPool = new ForkJoinPool(15);
		forkJoinPool.invoke(wordPrinter);
	}

}


