package com.ds.heap;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageInSlidingWIndow {
	int windowsize;
	Queue<Integer> queue;
	int sum;

	public MovingAverageInSlidingWIndow(int windowsize) {
		this.windowsize = windowsize;
		this.queue = new LinkedList<Integer>();
		this.sum = 0;
	}

	// finds moving average after inserting item n into data stream
	private double findMovingAverage(int n) {
		if (queue.size() > windowsize - 1) {
			sum = sum - queue.poll();
		}
		queue.offer(n);
		sum = sum + n;
		return (double) sum / queue.size();
	}

	public static void main(String[] args) {

		int windowsize = 3;
		MovingAverageInSlidingWIndow m = new MovingAverageInSlidingWIndow(windowsize);

		for (int i = 1; i < 20; i++) {
			System.out.println("After Adding " + i + " to the queue: {" + m.queue.toString() + "}; Average is:  " + m.findMovingAverage(i));

		}
	}
}
