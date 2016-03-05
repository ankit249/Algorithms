package com.ds.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ThreadPoolProcess implements Runnable {
	int id;

	ThreadPoolProcess(int id) {
		this.id = id;
	}

	public void run() {
		System.out.println("starting task: " + this.id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println("completing task: " + this.id);
	}
}

public class ThreadPools {

	public static void main(String[] args) {
		ExecutorService ex = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 10; i++) {
			ex.submit(new ThreadPoolProcess(i));
		}
		// wont shutdown immediately
		ex.shutdown();

		System.out.println("All tasks submitted");
		try {
			// if the timeout condition is met it will continue to execute after the following line but the tasks will
			// still complete and it only shuts down after that.
			ex.awaitTermination(100, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("All tasks completed");
	}
}
