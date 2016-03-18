package com.ds.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Runner1 {
	private int count;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void increment() {
		for (int i = 0; i < 10000; i++) {
			count++;
		}
	}

	public void firstThread() throws InterruptedException {
		lock.lock();
		System.out.println("Waiting....");
		condition.await();
		System.out.println("Woken up!");
		try {
			increment();
		} finally {
			lock.unlock();
		}
		System.out.println("finished counting in the first thread");
	}

	public void secondThread() throws InterruptedException {
		Thread.sleep(1000);
		lock.lock();
		System.out.println("press return");
		// String nextLine = new Scanner(System.in).nextLine();
		System.out.println("Got retruned key");
		// lock.lock(); // this will create deadlock
		condition.signal();
		try {
			increment();
		} finally {
			lock.unlock();
		}
		System.out.println("finished counting in the second thread");
	}

	public void finish() throws InterruptedException {
		System.out.println("count is: " + count);
	}

}

public class ReentrantLockExample {

	public static void main(String[] args) {

		final Runner1 r = new Runner1();

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					r.firstThread();
				} catch (InterruptedException ioe) {

				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					r.secondThread();
				} catch (InterruptedException ioe) {

				}
			}
		});

		t1.start();
		t2.start();

		// once both thread finishes

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException ioe) {
		}

		try {
			r.finish();
		} catch (InterruptedException ioe) {
		}
	}
}
