package com.ds.linklist;

public class CircleDetection {
	boolean hasCycle(ListNode head) {

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

}
