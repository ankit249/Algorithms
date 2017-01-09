package com.ds.Thread;

public class DeadLockSample {
	public static void main(String[] args) {
		String resource1 = "resource1";
		String resource2 = "resource2";

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				synchronized (resource1) {
					System.out.println("thread 1 synchronized on r1");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (resource2) {
						System.out.println("thread 1 synchronized on r2");
					}
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				synchronized (resource2) {
					System.out.println("thread 2 synchronized on r2");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (resource1) {
						System.out.println("thread 1 synchronized on r1");
					}
				}
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("This might not print");
	}
}
