package com.ds.linklist;

class Node {
	public int data;
	public Node next;
	public Node previous;

	public Node(int data) {
		this.data = data;
	}

}

public class DoublyLinkedList {
	Node head = null;
	Node tail = null;

	public void insertHead(int data) {
		Node tmp = new Node(data);
		if (head == null) {
			tail = tmp;
		} else {
			head.previous = tmp;
		}
		tmp.next = head;
		head = tmp;
	}

	public void insertTail(int data) {
		Node tmp = new Node(data);
		if (head == null) {
			head = tmp;
		} else {
			tail.next = tmp;
			tmp.previous = tail;
		}

		tail = tmp;
	}

	public void insertAfter(int data, int key) {

		// find key node
		Node n = head;
		while (n.data != key) {
			n = n.next;
		}

		// now insert after the current node.
		Node tmp = new Node(data);
		if (n == tail) {
			tail = tmp;
		} else {
			tmp.next = n.next;
			n.next.previous = tmp;
		}
		tmp.previous = n;
		n.next = tmp;

	}

	public void delete(int key) {

		// find key node
		Node n = head;
		while (n.data != key) {
			n = n.next;
		}

		if (n.previous == null) {
			head = n.next;
		} else {
			n.previous.next = n.next;
		}

		if (n.next == null) {
			tail = n.previous;
		} else {
			n.next.previous = n.previous;
		}

	}
	
	public void deleteHead() {
		if (head.next == null) {
			tail = null;
		} else {
			head.next.previous = null;
		}
		head = head.next;
	}

	public void deleteTail() {
		if (head.next == null) {
			head = null;
		} else {
			tail.previous.next = null;
		}
		tail = tail.previous;
	}

	public void print() {

		System.out.print("Node (head-->tail): ");
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}

		System.out.print(" |||| ");

		System.out.print("Node (tail-->head): ");
		current = tail;
		while (current != null) {
			System.out.print(current.data + " -> ");
			current = current.previous;
		}

	}

	public static void main(String[] args) {
		DoublyLinkedList l = new DoublyLinkedList();
		l.insertTail(4);
		l.insertTail(5);
		l.insertHead(1);
		// insert 7 after 4
		l.insertAfter(10, 4);
		l.insertAfter(9, 4);
		l.insertAfter(8, 4);
		l.insertAfter(7, 4);
		System.out.println();

		System.out.println("After all inserts: ");
		l.print();
		System.out.println();
		System.out.println();

		l.delete(4);
		System.out.println("After deleting node 4: ");
		l.print();
		System.out.println();
		System.out.println();

		l.deleteHead();
		System.out.println("After deleting head: ");
		l.print();
		System.out.println();
		System.out.println();

		l.deleteTail();
		System.out.println("After deleting tail: ");
		l.print();
		System.out.println();
		System.out.println();

		DoublyLinkedList m = new DoublyLinkedList();
		m.insertHead(1);
		m.insertHead(2);
		System.out.println("inserting head: ");
		m.print();
		System.out.println();
		System.out.println();

	}
}
