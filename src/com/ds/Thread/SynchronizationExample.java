package com.ds.Thread;

public class SynchronizationExample {

	// volatile will not work for thread interleaving, it only solves the caching problem
	private int count;

	// synchronized method will solve the problem of thread interleaving.
	// t1 will aquire the the lock object of this class and other thread t2 has to wait for t1 to finish its work
	// its not always advisable to use the same lock object for multiple threads.
	public synchronized void increment() {
		count++;
	}

	public static void main(String[] args) {
		SynchronizationExample se = new SynchronizationExample();
		se.doWork();
	}

	public void doWork() {

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}
		});

		t1.start();
		t2.start();

		try {
			// join method will wait for thread to finish its work and the count
			// statement below will print the final count.
			t1.join();
			t2.join();
		} catch (InterruptedException ioe) {

		}

		System.out.println("Finished, count = " + count);
	}
}
