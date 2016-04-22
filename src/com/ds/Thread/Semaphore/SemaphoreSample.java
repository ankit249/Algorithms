package com.ds.Thread.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SemaphoreSample {

	public static void main(String[] args) {

		// create a thread pool
		ExecutorService ex = Executors.newFixedThreadPool(200);
		for (int i = 0; i < 200; i++) {
			ex.submit(new Runnable() {
				public void run() {
					Connection.getInstance().connect();
				}
			});
		}

		ex.shutdown();
		try {
			ex.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
