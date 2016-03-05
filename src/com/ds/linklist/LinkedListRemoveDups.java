package com.ds.linklist;

// remove dups from sorted list
// 1->1->2->2 should give 1->2
public class LinkedListRemoveDups {

	public void add(ListNode head, int data) {
		ListNode tmp = new ListNode(data);
		ListNode current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = tmp;
	}

	public void print(ListNode p) {
		ListNode current = p;
		while (current != null) {
			System.out.print(current.data + "-->");
			current = current.next;
		}
		System.out.println();
	}

	public ListNode removeduplicate(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode previous = head;
		ListNode current = head.next;

		while (current != null) {
			if (previous.data == current.data) {
				previous.next = current.next;
			} else {
				previous = current;
			}
			current = current.next;
		}
		return head;
	}

	public static void main(String[] args) {
		LinkedListRemoveDups list = new LinkedListRemoveDups();
		ListNode head = new ListNode(1);
		list.add(head, 1);
		list.add(head, 2);
		list.add(head, 2);
		list.add(head, 2);
		list.add(head, 3);
		list.print(head);

		ListNode p = list.removeduplicate(head);
		list.print(p);

	}

}
