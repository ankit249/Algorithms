package com.ds.Thread;

import java.util.Random;

class PCTraditionalCount {
	private int count = 1;
	private int LIMIT = 10;
	private Random ramdom = new Random();

	Object lock1 = new Object();

	public void produce() throws InterruptedException {
		while (true) {
			synchronized (lock1) {
				while (count == LIMIT) {
					lock1.wait();
				}
				count++;
				System.out.println("producing count: " + count);
				lock1.notifyAll();
				// Thread.sleep(ramdom.nextInt(3000));
			}
		}
	}

	public void consume() throws InterruptedException {
		while (true) {
			synchronized (lock1) {
				// Thread.sleep(ramdom.nextInt(1000));
				while (count == 0) {
					System.out.println("waiting..");
					lock1.wait();
				}
				count--;
				Thread.sleep(ramdom.nextInt(3000));
				System.out.println("consumed, count is: " + count);
				lock1.notifyAll();
			}
		}
	}

}

public class ProducerConsumerTraditionalCount {

	public static void main(String[] args) {
		final PCTraditionalCount pc = new PCTraditionalCount();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException ie) {
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException ie) {
				}
			}
		});

		Thread t3 = new Thread(new Runnable() {
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException ie) {
				}
			}
		});

		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException ie) {
		}
	}
}
