package com.ds.Thread;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableSample {
	public static void main(String[] args) {
		// newCachedThreadPool vs new FixedThreadPool(10)
		ExecutorService service = Executors.newCachedThreadPool();
		Future<Integer> future = service.submit(new Callable<Integer>() {
			public Integer call() throws Exception {
				Random random = new Random();
				int duration = random.nextInt(4000);
				if (duration > 2000) {
					throw new IOException("Sleeping for too long");
				}
				System.out.println("Starting...");
				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					System.out.println("InterruptedException: " + e.getMessage());
				}
				System.out.println("Finished.");

				return duration;
			}
		});

		service.shutdown();

		try {
			service.awaitTermination(1000, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			System.out.println("future duration: " + future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			IOException iex = (IOException) e.getCause();
			System.out.println(iex.getMessage());
		}

	}
}
