package com.demo.sample.executorService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTask {

	public static class ArrayMultiplier extends RecursiveTask<Integer> {
		
		public ArrayMultiplier(Integer[] numbers, int start, int end) {
			this.numbers = numbers;
			this.start = start;
			this.end = end;
		}

		private static final long serialVersionUID = 1L;


		public Integer[] getNumbers() {
			return numbers;
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}

		private Integer[] numbers;
		private int start;
		private int end;

		@Override
		protected Integer compute() {
			if(end-start+1 > 2){
				int mid = (end+start)/2;
				System.out.println(Thread.currentThread().getName() + " : start "+start+ "end "+end);
				ArrayMultiplier arrayMultiplier1 = new ArrayMultiplier(numbers, start, mid);
				ArrayMultiplier arrayMultiplier2 = new ArrayMultiplier(numbers, mid+1, end);
				arrayMultiplier1.fork();
				arrayMultiplier2.fork();
				int result = arrayMultiplier1.join();
				result *= arrayMultiplier2.join();
				return result;

			}else{
				System.out.println(Thread.currentThread().getName() + " : start "+start+ "end "+end);
				if(start== end){
					return numbers[start];
				}else{
					return numbers[start]* numbers[end];
				}
			}
			
		}
	}
	
	public static void main(String ...args){
		Integer[] numbers = {2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		ArrayMultiplier arrayMultiplier = new ArrayMultiplier(numbers, 0, numbers.length-1);
		ForkJoinPool forkJoinPool = new ForkJoinPool(15);
		int result = forkJoinPool.invoke(arrayMultiplier);
		int check = 1; 
		for(int i = 0 ; i < numbers.length ; i++)
			check *= numbers[i];
		System.out.println(check+" - "+result);
	}

}


