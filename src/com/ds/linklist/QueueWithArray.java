package com.ds.linklist;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class QueueWithArray<E> {
	E[] a;
	int head;
	int tail;
	int current;

	public QueueWithArray(int size) {
		a = (E[]) new Object[size];
		current = 0;
		head = -1;
		tail = -1;
	}

	public void offer(E item) {
		if (current == a.length) {
			System.out.println("can't add");
			return;
		}

		tail = (tail + 1) % a.length;
		a[tail] = item;
		current++;

		if (head == -1) {
			head = tail;
		}
	}

	public E poll() {
		if (current == 0) {
			System.out.println("Empty Queue");
			return null;
		}

		E result = a[head];
		a[head] = null;
		head = (head + 1) % a.length;
		current--;

		if (current == 0) {
			head = -1;
			tail = -1;
		}

		return result;
	}

	public E peek() {
		if (current == 0) {
			return null;
		}

		return a[tail];
	}

	public static void main(String[] args) {
		QueueWithArray<Integer> q = new QueueWithArray<Integer>(5);
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

		q.poll();
		System.out.println(Arrays.toString(q.a));

		QueueWithArray<String> q1 = new QueueWithArray<String>(5);
		q1.offer(1 + "");
		q1.offer(2 + "");
		q1.offer(3 + "");
		q1.offer(4 + "");
		q1.offer(5 + "");
		q1.offer(6 + "");

		System.out.println(q1.poll());
		q1.offer(6 + "");
		System.out.println(q1.poll());

		System.out.println(Arrays.toString(q1.a));
		q1.offer(7 + "");
		System.out.println(Arrays.toString(q1.a));

		q1.poll();
		System.out.println(Arrays.toString(q1.a));
	}
}
