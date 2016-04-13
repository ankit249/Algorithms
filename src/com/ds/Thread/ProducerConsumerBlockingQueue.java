package com.ds.Thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ProducerConsumer3 {
	// use queue.put() and queue.take() method because they are concurrent and syncronized.
	// don't use queue.remove()
	// ArrayBlockingQueue uses Reentrant locks
	private BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
	Random random = new Random();

	public void produce() throws InterruptedException {
		while (true) {
			Thread.sleep(5000);
			queue.put(random.nextInt(100 - 1) + 1);
		}
	}

	public void consume() throws InterruptedException {
		while (true) {
			Thread.sleep(100);
			System.out.print("Queue size: " + queue.size());
			Integer val = queue.take();
			System.out.println("; removed: " + val);
		}
	}
}

public class ProducerConsumerBlockingQueue {

	public static void main(String[] args) {

		// has to be final and inside main() and not outside.
		final ProducerConsumer3 pc = new ProducerConsumer3();

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
				}
			}
		});

		t1.start();
		t2.start();

	}
}
