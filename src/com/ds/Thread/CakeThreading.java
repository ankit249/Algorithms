package com.ds.Thread;

import java.util.LinkedList;
import java.util.Random;

class Cake {
	private int weight;
	private String color;

	public Cake(int weight, String color) {
		this.weight = weight;
		this.color = color;
	}

	public String toString() {
		return "The cake is in " + color + " and is " + weight + " gram ";

	}
}

class CakeMachine {

	private LinkedList<Cake> listCake = new LinkedList<Cake>();;
	private Random random = new Random();
	private static int LIMIT = 5;

	public void makeCake() throws InterruptedException {
		while (true) {
			synchronized (this) {
				while (listCake.size() == LIMIT) {
					wait();
				}
				int weight = random.nextInt(20);
				Cake cake = new Cake(weight, "color code is  " + weight);
				listCake.add(cake);
				System.out.println("cake has been cooked ");
				notify();
			}
		}
	}

	public void deliverCake() throws InterruptedException {
		while (true) {
			synchronized (this) {
				Thread.sleep(random.nextInt(1000)); // on average 500 ms
				while (listCake.size() == 0) {
					System.out.println("Waiter is waiting for the cake ");
					wait();
				}

				Cake cake = listCake.removeFirst();
				System.out.println(cake.toString() + "has been delivered to customers ");
				notify();
			}
		}
	}

}


public class CakeThreading {


	public static void main(String[] args) {

		final CakeMachine cm = new CakeMachine();
		Thread cakeproducer = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					cm.makeCake();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});

		Thread waiter = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					cm.deliverCake();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});

		cakeproducer.start();
		waiter.start();

		try {
			cakeproducer.join();
			waiter.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}