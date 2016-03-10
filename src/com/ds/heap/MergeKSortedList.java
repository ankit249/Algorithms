package com.ds.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class ListNode {
	ListNode next;
	int data;

	public ListNode(int d) {
		this.data = d;
		this.next = null;
	}
}

public class MergeKSortedList {

	public ListNode mergeList(List<ListNode> list) {

		if (list == null || list.size() == 0) {
			return null;
		}

		// priorityQueue
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(list.size(), new Comparator<ListNode>() {
			public int compare(ListNode a, ListNode b) {
				return a.data - b.data;
			}
		});

		for (ListNode listnode : list) {
			if (list != null) {
				pq.add(listnode);
			}
		}

		// System.out.println("priority queue: " + pq);
		ListNode head = new ListNode(0);
		ListNode current = head;
		while (!pq.isEmpty()) {
			ListNode tmp = pq.poll();
			current.next = tmp;
			if (tmp.next != null) {
				pq.add(tmp.next);
			}
			current = current.next;
		}
		return head.next;
	}

	public void add(ListNode head, int d) {
		ListNode temp = new ListNode(d);
		ListNode current = head;

		while (current.next != null) {
			current = current.next;
		}
		current.next = temp;
	}

	public void print(ListNode head) {
		ListNode current = head;

		while (current != null) {
			System.out.print(current.data + "-->");
			current = current.next;
		}

		System.out.println();
	}

	public static void main(String[] args) {
		MergeKSortedList m = new MergeKSortedList();

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(8);
		ListNode l3 = new ListNode(16);

		m.add(l1, 2);
		m.add(l1, 5);
		m.add(l1, 9);
		m.add(l1, 15);
		System.out.print("list l1: ");
		m.print(l1);

		m.add(l2, 13);
		m.add(l2, 14);
		m.add(l2, 25);
		System.out.print("list l2: ");
		m.print(l2);

		m.add(l3, 22);
		m.add(l3, 23);
		m.add(l3, 24);
		System.out.print("list l3: ");
		m.print(l3);

		List<ListNode> list = new ArrayList<ListNode>();
		list.add(l2);
		list.add(l1);
		list.add(l3);

		ListNode result = m.mergeList(list);
		System.out.print("Merging K lists: ");
		m.print(result);
	}

}
