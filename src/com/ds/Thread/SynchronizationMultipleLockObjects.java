package com.ds.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class P1 {

	Random random = new Random();
	List<Integer> list1 = new ArrayList<Integer>();
	List<Integer> list2 = new ArrayList<Integer>();
	private static final int max = 100;
	private static final int min = 50;

	// we want stage1() and stage2() methods to be run in parellel with two different threads
	// we can synchronized stage1() and stage2() but since it will use only one object's lock, its not really parellel
	// thats why we need to use two different lock objects.
	Object lock1 = new Object();
	Object lock2 = new Object();

	public void stageOne() {
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
			list1.add(random.nextInt(max - min) + min);
		}

	}

	public void stageTwo() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
			list2.add(random.nextInt(max - min) + min);
		}
	}

	public void process() {
		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}

	public void doWork() {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				process();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				process();
			}
		});

		long start = System.currentTimeMillis();

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException ioe) {

		}

		long end = System.currentTimeMillis();

		// should print a little more than 2 seconds (exact will be 2 seconds but some time for context switching)
		System.out.println("time taken: " + (end - start));
		System.out.println("list 1 size: " + list1.size() + " , list 2 size: " + list2.size());
	}
}

public class SynchronizationMultipleLockObjects {
	public static void main(String[] args) {
		new P1().doWork();
	}
}
