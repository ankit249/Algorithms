package com.ds.linklist;

public class ReverseList {

	public static void main(String[] args) {
		ReverseList l = new ReverseList();

		ListNode head = new ListNode(4);
		l.add(head, 1);
		l.add(head, 8);
		l.add(head, 2);
		l.add(head, 2);
		l.add(head, 3);
		System.out.print("After all inserts: ");
		l.print(head);
		System.out.println();

		System.out.print("reversing the list: ");
		ListNode n = l.reverseList(head);
		l.print(n);
		System.out.println();

		head = new ListNode(4);
		l.add(head, 1);
		l.add(head, 8);
		l.add(head, 2);
		l.add(head, 2);
		l.add(head, 3);
		System.out.print("After all inserts: ");
		l.print(head);
		System.out.println();

		System.out.print("recursive reverse the list: ");
		ListNode current = head;
		ListNode previous = null;
		head = l.recursiveReverse(previous, current);
		l.print(head);
		System.out.println();
	}

	public ListNode reverseList(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode previous = null;
		ListNode current = head;

		while (current != null) {
			ListNode tmp = current.next;
			current.next = previous;
			previous = current;
			current = tmp;
		}

		head = previous;
		return head;
	}

	public ListNode recursiveReverse(ListNode previous, ListNode current) {
		if (current.next == null) {
			current.next = previous;
			return current;
		} else {
			ListNode tmp = current.next;
			current.next = previous;
			return recursiveReverse(current, tmp);
		}
	}

	public void print(ListNode head) {
		ListNode current = head;

		while (current != null) {
			System.out.print(current.data + "-->");
			current = current.next;
		}

		System.out.println();
	}

	public void add(ListNode head, int d) {
		ListNode temp = new ListNode(d);
		ListNode current = head;

		while (current.next != null) {
			current = current.next;
		}
		current.next = temp;
	}
}
