package com.ds.linklist;

public class PalindromList {
	public static void main(String[] args) {
		PalindromList l = new PalindromList();

		ListNode head = new ListNode(4);
		l.add(head, 1);
		l.add(head, 8);
		l.add(head, 7);
		l.add(head, 8);
		l.add(head, 1);
		l.add(head, 4);

		System.out.print("After all inserts: ");
		l.print(head);
		System.out.println();

		System.out.println("is list palindrome: " + l.isPalindrome(head));

	}

	// get to the middle
	public boolean isPalindrome(ListNode head) {

		if (head == null)
			return false;

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode secondList = slow.next;
		// print(secondList);

		slow.next = null; // cut the first list off

		// reverse the secondList
		ListNode reverseList = reverse(secondList);
		// print(reverseList);

		ListNode c1 = head;
		ListNode c2 = reverseList;

		while (c1.next != null && c2.next != null) {
			if (c1.data != c2.data) {
				return false;
			}
			c1 = c1.next;
			c2 = c2.next;
		}

		// need condition if while exits before going thru either c1 or c2

		return true;
	}

	public ListNode reverse(ListNode head) {
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
