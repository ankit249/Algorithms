package com.ds.Thread;

import java.util.Scanner;

class Processor extends Thread {

	// In some systems running variable might be cached by the thread and even after calling shutdown it wont change the value 
	// of running, thats why volatile is needed.
	private volatile boolean running = true;

	public void run() {
		while (running) {
			System.out.println("hello");

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void shutdown() {
		running = false;
	}
}

public class VolatileExample {
	public static void main(String[] args) {
		Processor p = new Processor();
		p.start();

		System.out.println("press return to continue");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();

		p.shutdown();

	}
}
