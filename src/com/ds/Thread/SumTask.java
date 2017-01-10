package com.ds.Thread;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

// understand fork join pool
// http://www.javacreed.com/java-fork-join-example/
public class SumTask extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 1L;

	static final int CHUNK_SIZE = 3; // execution batch size;
	Integer[] a;
	int lo;
	int hi;

	SumTask(Integer[] a, int lo, int hi) {
		this.a = a;
		this.lo = lo;
		this.hi = hi;
	}

	@Override
	protected Integer compute() {
		// sums the given number

		// problem is small - so solve the problem
		if (hi - lo < CHUNK_SIZE) {
			int sum = 0;
			List<Integer> processedNumbers = new ArrayList<Integer>();
			for (int i = lo; i <= hi; i++) {
				processedNumbers.add(a[i]);// just to track
				sum += a[i];
			}
			// tracking thread, numbers processed, and sum
			System.out.println(Thread.currentThread().getName() + " proceesing " + Arrays.asList(processedNumbers) + ", sum = " + sum);
			return sum;
		}

		// create chunks, fork and join
		// split the problem into smaller problem
		else {
			int mid = (lo + hi) / 2; // mid point to partition
			SumTask t1 = new SumTask(a, lo, mid - 1); // t1 partition
			t1.fork(); // asynchronously execute on a separate thread

			SumTask t2 = new SumTask(a, mid, hi); // t2 partition
			return t2.compute() + t1.join();
			 
			// int leftAns = t2.compute(); // recurse and compute
			// int rightAns = t1.join(); // returns the asynchronously executed result
			// System.out.println("leftAns=" + leftAns + " + " + "rightAns=" + rightAns);
			 

		}
	}

	public static void main(String[] args) {
		// int numberOfCpuCores = Runtime.getRuntime().availableProcessors();
		// ForkJoinPool forkJoinPool = new ForkJoinPool(numberOfCpuCores);

		ForkJoinPool forkJoinPool = new ForkJoinPool();

		Integer[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int sum = forkJoinPool.invoke(new SumTask(a, 0, a.length - 1));

		System.out.println(sum);
	}
}
