package com.ds.linklist;

public class CircleDetectionLengthOfLoop {
	public void add(ListNode head, int data) {
		ListNode tmp = new ListNode(data);
		ListNode current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = tmp;
	}

	public static void print(ListNode p) {
		ListNode current = p;
		while (current != null) {
			System.out.print(current.data + "-->");
			current = current.next;
		}
		System.out.println();
	}

	// TC - O(n + lambda) where lambda <=n which is equates to O(n), SC - O(1)
	private static int countLoopInCycle(ListNode head) {

		if (head == null) // list does not exist..so no loop either.
			return -1;

		ListNode slow = head; // create two references.
		ListNode fast = head; // make both refer to the start of the list.

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return count(slow);
			}
		}

		return -1;
	}

	private static int count(ListNode slow) {
		ListNode tmp = slow;
		int count = 1;
		while(tmp.next != slow) {
			tmp = tmp.next;
			count ++;
		}
		return count;
	}

	public static void main(String[] args) {

		// even nummber of elements - use second middle node
		CircleDetectionLengthOfLoop list = new CircleDetectionLengthOfLoop();


		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		/* Create a loop for testing */
		head.next.next.next.next.next = head.next;
		// infinite loop
		//print(head);

		System.out.println( countLoopInCycle(head));
	}

}
