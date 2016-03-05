package com.ds.linklist;

// first and and last pointer, different from linklist is the last pointer
// 1---> 2 ---> 3 -->
// first      last
public class Queue {

	class ListNode {
		ListNode next;
		int data;

		ListNode(int data) {
			this.data = data;
		}
	}

	ListNode first, last;

	public ListNode dequeue() {
		if (first == null) {
			return null;
		}
		ListNode tmp = first;
		first = first.next;
		return tmp;
	}

	public void enqueue(int d) {
		ListNode tmp = new ListNode(d);
		if (first == null) {
			first = tmp;
			last = first;
		} else {
			last.next = tmp;
			last = last.next;
		}
	}

	public void print() {
		ListNode current = first;
		while (current != null) {
			System.out.print(current.data + "->");
			current = current.next;
		}

		System.out.println();
	}

	public static void main(String[] args) {
		Queue q = new Queue();

		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		System.out.print("queue: ");
		q.print();

		System.out.print("deque: " + q.dequeue().data + "   ");
		q.print();

		System.out.print("deque: " + q.dequeue().data + "   ");
		q.print();

		System.out.print("deque: " + q.dequeue().data + "   ");
		q.print();

		System.out.print("deque: " + (q.dequeue() != null ? q.dequeue().data : " ") + " ");
		q.print();

	}
}
