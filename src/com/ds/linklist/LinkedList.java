package com.ds.linklist;

import java.util.HashSet;
import java.util.Set;

// adding at the end
// 1-->2-->3-->4-->
// head
// current

class ListNode {
	ListNode next;
	int data;

	public ListNode(int d) {
		this.data = d;
		this.next = null;
	}
}

public class LinkedList {

	public void add(ListNode head, int d) {
		ListNode temp = new ListNode(d);
		ListNode current = head;

		while (current.next != null) {
			current = current.next;
		}
		current.next = temp;
	}

	public boolean delete(ListNode head, int searchValue) {
		ListNode current = head;
		ListNode previous = null;
		boolean deletedNode = false;

		while (current != null) {
			// once you find the seached Value
			if (current.data == searchValue) {

				System.out.println("deleting :" + current.data);

				if (current == head) {
					head = head.next;
				} else {
					previous.next = current.next;
				}
				deletedNode = true;
			}

			previous = current;
			current = current.next;
		}

		return deletedNode;
	}

	public void print(ListNode head) {
		ListNode current = head;

		while (current != null) {
			System.out.print(current.data + "-->");
			current = current.next;
		}

		System.out.println();
	}

	public void deleteDuplicate(ListNode head) {
		ListNode current = head;
		ListNode previous = null;
		Set<Integer> set = new HashSet<Integer>();
		while (current != null) {
			if (set.contains(current.data)) {
				previous.next = current.next;
			} else {
				previous = current;
				set.add(current.data);
			}
			current = current.next;
		}
	}



	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		ListNode head = new ListNode(4);
		l.add(head, 1);
		l.add(head, 8);
		l.add(head, 2);
		l.add(head, 2);
		l.add(head, 3);
		System.out.print("After all inserts: ");
		l.print(head);
		System.out.println();

		System.out.print("Delete Node 8: ");
		boolean deletedNode = l.delete(head, 8);
		System.out.println("record found: " + deletedNode);
		System.out.print("After deleting 8: ");
		l.print(head);
		System.out.println();

		System.out.print("After deleting duplicates from list: ");
		l.deleteDuplicate(head);
		l.print(head);
		

	}

}
