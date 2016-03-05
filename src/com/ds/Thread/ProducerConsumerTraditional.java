package com.ds.Thread;

import java.util.LinkedList;
import java.util.Random;

// using class's intrinsic lock object
class ProducerConsumer1 {
	private LinkedList<Integer> list = new LinkedList<Integer>();
	private static final int LIMIT = 10;
	private Random random = new Random();
	private static final int min = 50;
	private static final int max = 100;
	public void produce() throws InterruptedException {
		while (true) {
			synchronized (this) {
				while (list.size() == LIMIT) {
					wait();
				}
				list.add(random.nextInt(max - min) + min);
				notify();
			}
		}
	}
	public void consume() throws InterruptedException {
		while (true) {
			synchronized (this) {
				Thread.sleep(random.nextInt(1000)); // on average 500 ms
				while (list.size() == 0) {
					wait();
				}
				System.out.print("list size: " + list.size());
				int value = list.removeFirst();
				System.out.println("; removing" + value);
				notify();
			}
		}
	}
}
public class ProducerConsumerTraditional {
	public static void main(String[] args) {
		// make sure to have this variable as final
		final ProducerConsumer1 producerConsumer = new ProducerConsumer1();
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
		 * try { t1.join(); t2.join(); } catch (InterruptedException ioe) { }
		 */
	}
}
