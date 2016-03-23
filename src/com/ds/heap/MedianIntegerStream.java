package com.ds.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

// logic,
// two priority queue, min and max
// alsways insert into Max
// if count of element is odd insert into min priority queue by polling the element from max
// if count of element is even and max pq element is greater than minPQ then poll both pq and insert them into one another (exchange)
public class MedianIntegerStream {

	static PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>();
	static PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	}); // // first arugument 1 is for initial size
	// you can also do this:
	// static PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(1, Collections.reverseOrder());;
	static int count = 0;

	private static void insertNumberToStream(int num) {
		maxPQ.offer(num);
		if (count % 2 == 0) {
			if (minPQ.isEmpty()) {
				count++;
				return;
			} else if (maxPQ.peek() > minPQ.peek()) { // only else would not work, fails the hackerrank test
				Integer maxroot = maxPQ.poll();
				Integer minroot = minPQ.poll();
				maxPQ.offer(minroot);
				minPQ.offer(maxroot);
			}
		} else {
			minPQ.offer(maxPQ.poll());
		}
		count++;
	}

	public static void main(String[] args) {

		// Scanner scanner = new Scanner(System.in);
		// int n = scanner.nextInt();
		int n = 10;
		for (int i = 0; i < n; i++) {
			// int number = scanner.nextInt();
			int number = i + 1;
			insertNumberToStream(number);
			System.out.println("after inserting number " + number + " :" + getMedian());
		}
	}

	private static double getMedian() {

		double median = 0;

		// this will work too minPQ.size() == maxPQ.size()
		if (count % 2 == 0) {
			median = (minPQ.peek() + maxPQ.peek()) / 2.0;
		} else {
			median = new Double(maxPQ.peek());
		}

		return median;
	}

}
