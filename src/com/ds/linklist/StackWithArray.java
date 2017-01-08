package com.ds.linklist;

import java.util.NoSuchElementException;

public class StackWithArray {
	Integer[] a;
	int top;
	int count;
	int capacity;

	public StackWithArray(int capacity) {
		this.a = new Integer[capacity];
		this.capacity = capacity;
		this.top = -1;
		this.count = 0;
	}

	public void push(int item) {
		if (capacity == count) {
			throw new NoSuchElementException("stack full");
		}
		top++;
		a[top] = item;
		count++;
	}

	public Integer pop() {
		if (count == 0) {
			throw new NoSuchElementException("stack empty");
		}
		Integer item = a[top];
		a[top] = null;
		top--;
		count--;
		return item;
	}

	public Integer peek() {
		return top == -1 ? null : a[top];
	}

	public static void main(String[] args) {
		int cap = 4;
		StackWithArray s = new StackWithArray(cap);

		for (int i = 0; i < cap; i++) {
			s.push(i);
		}
		System.out.println(s.peek());
		for (int i = 0; i < cap; i++) {
			System.out.println(s.pop());
		}
		System.out.println(s.peek());
	}
}
