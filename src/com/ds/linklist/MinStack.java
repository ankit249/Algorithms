package com.ds.linklist;

class MinNode {
	MinNode next;
	int data;
	int min;

	MinNode(int data) {
		this.data = data;
		this.min = data;
		this.next = null;
	}
}

public class MinStack {
	MinNode top;

	public void push(int data) {
		MinNode tmp = new MinNode(data);
		if (top != null) {
			tmp.min = Math.min(top.min, data);
		}
		tmp.next = top;
		top = tmp;
	}

	public MinNode pop() {
		if (top == null) {
			return null;
		}

		MinNode tmp = top;
		top = top.next;
		return tmp;
	}

	public int getMinimum() {
		if (top == null) {
			return -1;
		}

		return top.min;
	}

	public static void main(String[] args) {
		MinStack m = new MinStack();
		m.push(3);
		m.push(2);
		m.push(1);
		m.push(4);
		m.push(5);
		// System.out.println(m.getMinimum());
		while (m.pop() != null) {
			System.out.println(m.getMinimum());
		}

	}

}
