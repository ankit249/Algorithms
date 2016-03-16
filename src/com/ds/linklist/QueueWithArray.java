package com.ds.linklist;

import java.lang.reflect.Array;
import java.util.Arrays;

@SuppressWarnings("unchecked")
public class QueueWithArray<T> {
	T[] a;
	int head;
	int tail;
	int current;

	public QueueWithArray(Class<T> c, int size) {
		a = (T[]) Array.newInstance(c, size);
		current = 0;
		head = -1;
		tail = -1;
	}

	public void offer(T item) {
		if (current == a.length) {
			System.out.println("can't add");
			return;
		}

		head = (head + 1) % a.length;
		a[head] = item;
		current++;

		if (tail == -1) {
			tail = head;
		}
	}

	public T poll() {
		if (current == 0) {
			System.out.println("Empty Queue");
			return null;
		}

		T result = a[tail];
		a[tail] = null;
		tail = (tail + 1) % a.length;
		current--;

		if (current == 0) {
			head = -1;
			tail = -1;
		}

		return result;
	}

	public T peek() {
		if (current == 0) {
			return null;
		}

		return a[tail];
	}

	public static void main(String[] args) {
		QueueWithArray<Integer> q = new QueueWithArray<Integer>(Integer.class, 5);
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
	}
}
