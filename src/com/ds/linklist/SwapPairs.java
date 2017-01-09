package com.ds.linklist;

public class SwapPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		// a fake head
		ListNode fake = new ListNode(0);
		fake.next = head;

		ListNode c1 = head;
		ListNode c2 = head.next;

		ListNode previous = fake;
		while (c1 != null && c2 != null) {
			previous.next = c2;

			ListNode t = c2.next;
			c2.next = c1;
			previous = c1;
			c1.next = t;

			c1 = c1.next;

			if (t != null)
				c2 = t.next;
		}

		return fake.next;
	}
}
