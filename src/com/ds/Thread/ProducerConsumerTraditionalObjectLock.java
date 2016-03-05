package com.ds.Thread;

import java.util.LinkedList;
import java.util.Random;

// using objects lock method instead of the intrinsic lock object (this)
class ProducerConsumer2 {

	private LinkedList<Integer> list = new LinkedList<Integer>();
	private int LIMIT = 10;
	private Random random = new Random();
	private Object lock = new Object();

	public void produce() throws InterruptedException {
		int value = 0;

		while (true) {
			synchronized (lock) {
				while (list.size() == LIMIT) {
					lock.wait();
				}
				list.add(value++);
				lock.notify();
			}
		}
	}

	public void consume() throws InterruptedException {
		while (true) {
			synchronized (lock) {
				Thread.sleep(random.nextInt(1000)); // on average 500 ms
				while (list.size() == 0) {
					lock.wait();
				}
				System.out.print("list size: " + list.size());
				int value = list.removeFirst();
				System.out.println("; removing" + value);
				lock.notify();
			}

		}
	}
}

public class ProducerConsumerTraditionalObjectLock {

	public static void main(String[] args) {

		// make sure to have this variable as final
		final ProducerConsumer2 producerConsumer = new ProducerConsumer2();

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					producerConsumer.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					producerConsumer.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();

		// no need for join here because we are not doing anything after these threads starts, not even printing
		// so need to wait

		/*
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException ioe) {
		}
		*/
	}
}
