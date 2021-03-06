package com.ds.linklist;

public class CircleDetection {
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

	// TC - O(n + lambda) where lambda <=n which is equates to O(n), SC - O(1)
	private boolean hasCycle(ListNode head) {

		if (head == null) // list does not exist..so no loop either.
			return false;

		ListNode slow = head; // create two references.
		ListNode fast = head; // make both refer to the start of the list.

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {

		// even nummber of elements - use second middle node
		CircleDetection list = new CircleDetection();
		ListNode head = new ListNode(1);
		list.add(head, 2);
		list.add(head, 3);
		list.add(head, 4);
		list.add(head, 5);
		list.add(head, 6);

		//list.add(head, 7);

		list.print(head);


		System.out.println(list.hasCycle(head));


	}

}
