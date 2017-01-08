package com.ds.linklist;

import java.util.NoSuchElementException;

public class StackWithArrayGenerics<E> {
	E[] a;
	int top;
	int count;
	int capacity;

	@SuppressWarnings("unchecked")
	public StackWithArrayGenerics(int capacity) {
		this.a = (E[]) new Object[capacity];
		this.capacity = capacity;
		this.top = -1;
		this.count = 0;
	}

	public void push(E item) {
		if (capacity == count) {
			throw new NoSuchElementException("stack full");
		}
		top++;
		a[top] = item;
		count++;
	}

	public E pop() {
		if (count == 0) {
			throw new NoSuchElementException("stack empty");
		}
		E item = a[top];
		a[top] = null;
		top--;
		count--;
		return item;
	}

	public E peek() {
		return top == -1 ? null : a[top];
	}

	public static void main(String[] args) {
		int cap = 4;
		StackWithArrayGenerics<String> s = new StackWithArrayGenerics<String>(cap);

		for (int i = 0; i < cap; i++) {
			s.push("hello " + i);
		}
		System.out.println(s.peek());
		for (int i = 0; i < cap; i++) {
			System.out.println(s.pop());
		}
		System.out.println(s.peek());
	}
}
