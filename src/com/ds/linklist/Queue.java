package com.ds.linklist;

// first and and last pointer, different from linklist is the last pointer
// 1---> 2 ---> 3 -->
// head      tail
public class Queue {

	class ListNode {
		ListNode next;
		int data;

		ListNode(int data) {
			this.data = data;
		}
	}

	ListNode head, tail;

	public ListNode poll() {
		if (head == null) {
			return null;
		}
		ListNode tmp = head;
		head = head.next;
		return tmp;
	}

	public void offer(int d) {
		ListNode tmp = new ListNode(d);
		if (head == null) {
			head = tmp;
		} else {
			tail.next = tmp;
		}

		tail = tmp;
	}

	public void print() {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.data + "->");
			current = current.next;
		}

		System.out.println();
	}

	public static void main(String[] args) {
		Queue q = new Queue();

		q.offer(4);
		q.offer(5);
		q.offer(6);
		System.out.print("queue: ");
		q.print();

		System.out.print("deque: " + q.poll().data + "   ");
		q.print();

		System.out.print("deque: " + q.poll().data + "   ");
		q.print();

		System.out.print("deque: " + q.poll().data + "   ");
		q.print();

		System.out.print("queue 10: ");
		q.offer(10);
		q.print();

		System.out.print("deque: " + q.poll().data + "   ");
		q.print();

		System.out.print("deque: " + (q.poll() != null ? q.poll().data : " ") + " ");
		q.print();

	}
}
