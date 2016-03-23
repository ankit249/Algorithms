package com.ds.Thread;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This is the classic dining philosophers problem. See the textbook for a description of the problem. This version will
 * not deadlock because if you can't acquire both chopsticks you put down what ever is acquired
 * 
 *
 */
class Philosopher implements Runnable {

	private ReentrantLock leftChopStick;
	private ReentrantLock rightChopStick;
	private int Id;

	// might not be needed in the interview
	public AtomicBoolean isTummyFull = new AtomicBoolean(false);

	// To randomize eat/Think time
	private Random randomGenerator = new Random();

	// might not be needed in the interview
	private int noOfTurnsToEat = 0;

	public int getId() {
		return this.Id;
	}

	public int getNoOfTurnsToEat() {
		return noOfTurnsToEat;
	}

	/****
	 * 
	 * @param id
	 *            Philosopher number
	 * 
	 * @param leftChopStick
	 * @param rightChopStick
	 */
	public Philosopher(int id, ReentrantLock leftChopStick, ReentrantLock rightChopStick) {
		this.Id = id;
		this.leftChopStick = leftChopStick;
		this.rightChopStick = rightChopStick;
	}

	@Override
	public void run() {

		while (!isTummyFull.get()) { // you can use a while(true) loop as well in the interview and no need to use the
										// isTummyFull variable
			try {
				think();
				if (pickupLeftChopStick() && pickupRightChopStick()) {
					eat();
				}
				putDownChopSticks();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void think() throws InterruptedException {
		System.out.println(String.format("Philosopher %s is thinking", this.Id));
		System.out.flush();
		Thread.sleep(randomGenerator.nextInt(1000));
	}

	private void eat() throws InterruptedException {
		System.out.println(String.format("Philosopher %s is eating", this.Id));
		System.out.flush();
		noOfTurnsToEat++;
		Thread.sleep(randomGenerator.nextInt(1000));
	}

	private boolean pickupLeftChopStick() throws InterruptedException {
		if (leftChopStick.tryLock(10, TimeUnit.MILLISECONDS)) {
			System.out.println(String.format("Philosopher %s pickedup Left ChopStick", this.Id));
			System.out.flush();
			return true;
		}
		return false;
	}

	private boolean pickupRightChopStick() throws InterruptedException {
		if (rightChopStick.tryLock(10, TimeUnit.MILLISECONDS)) {
			System.out.println(String.format("Philosopher %s pickedup Right ChopStick", this.Id));
			System.out.flush();
			return true;
		}
		return false;
	}

	private void putDownChopSticks() {
		if (leftChopStick.isHeldByCurrentThread()) {
			leftChopStick.unlock();
			System.out.println(String.format("Philosopher %s putdown Left ChopStick", this.Id));
			System.out.flush();
		}
		if (rightChopStick.isHeldByCurrentThread()) {
			rightChopStick.unlock();
			System.out.println(String.format("Philosopher %s putdown Right ChopStick", this.Id));
			System.out.flush();
		}
	}
}

public class DiningPhilosophers {

	private static final int NO_OF_PHILOSOPHER = 5;
	private static final int SIMULATION_MILLIS = 1000 * 60; // run for one minute and be done

	public static void main(String args[]) throws InterruptedException {
		ExecutorService executorService = null;

		Philosopher[] philosophers = null;
		try {

			philosophers = new Philosopher[NO_OF_PHILOSOPHER];

			// As many forks as Philosophers
			ReentrantLock[] locks = new ReentrantLock[NO_OF_PHILOSOPHER];
			Arrays.fill(locks, new ReentrantLock()); // this is equivalent to running a for lop for NO_OF_PHILOSOPHERS
														// times and instantiate the locks elements with the new
														// Rentrant lock

			executorService = Executors.newFixedThreadPool(NO_OF_PHILOSOPHER);

			for (int i = 0; i < NO_OF_PHILOSOPHER; i++) {
				philosophers[i] = new Philosopher(i, locks[i], locks[(i + 1) % NO_OF_PHILOSOPHER]);
				executorService.execute(philosophers[i]);
			}
			// Main thread sleeps till time of simulation
			Thread.sleep(SIMULATION_MILLIS);
			
			

			for (Philosopher philosopher : philosophers) {
				philosopher.isTummyFull.set(true);
			}

			// all philosophers are done eating...

		} finally {
			executorService.shutdown();

			// Wait period for all thread to finish
			Thread.sleep(1000);

			// Time for check
			for (Philosopher philosopher : philosophers) {
				System.out.println("Philosopher (" + philosopher.getId() + ") =>No of Turns to Eat ="
						+ philosopher.getNoOfTurnsToEat());
				System.out.flush();
			}
		}
	}
}