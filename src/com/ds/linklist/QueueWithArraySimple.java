package com.ds.linklist;

import java.util.Arrays;

public class QueueWithArraySimple {
	Integer[] a;
	int head = -1;
	int tail = -1;
	int current;

	QueueWithArraySimple(int size) {
		a = new Integer[size];
		current = 0;
	}

	public void offer(int element) {
		if (current == a.length) {
			System.out.println("Queue is full, can't add.");
			return;
		}

		head = (head + 1) % a.length;
		a[head] = element;
		current++;

		if (tail == -1) {
			tail = head;
		}
	}

	public Integer poll() {
		if (current == 0) {
			System.out.println("Queue is empty; can't remove.");
			return null;
		}

		int result = a[tail];
		a[tail] = null;

		tail = (tail + 1) % a.length;
		current--;

		if (current == 0) {
			head = -1;
			tail = -1;
		}
		return result;
	}

	public static void main(String[] args) {
		QueueWithArraySimple q = new QueueWithArraySimple(5);
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.offer(4);
		q.offer(5);
		q.offer(6);

		System.out.println(q.poll());
		q.offer(6);
		System.out.println(q.poll());

		System.out.println(Arrays.toString(q.a));
		q.offer(7);
		System.out.println(Arrays.toString(q.a));
	}
}
