package com.ds.linklist;

// remove dups from sorted list
// 1->1->2->2->3->4 should give 3->4
public class LinkListRevmoeDupsPart2 {

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
		ListNode tmp;

		while (current != null) {
			tmp = current.next;
			if (previous.data == current.data) {
				if (previous == head) {
					head = tmp;
				}
				previous = tmp;
				current = tmp.next;
			} else {
				previous = current;
				current = tmp;
			}
		}

		return head;
	}

	// not working for 1->2->2->3 case.
	public static void main(String[] args) {
		LinkListRevmoeDupsPart2 list = new LinkListRevmoeDupsPart2();
		ListNode head = new ListNode(1);
		list.add(head, 1);
		list.add(head, 2);
		list.add(head, 2);
		list.add(head, 3);
		// list.add(head, 2);
		// list.add(head, 2);
		// list.add(head, 3);
		// list.add(head, 4);
		// list.print(head);

		ListNode p = list.removeduplicate(head);
		list.print(p);

	}

}
