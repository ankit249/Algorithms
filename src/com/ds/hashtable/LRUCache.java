package com.ds.hashtable;

import java.util.HashMap;

/**
 * http://www.programcreek.com/2013/03/leetcode-lru-cache-java/
 */

public class LRUCache {

	class Node {
		int key;
		int data;
		Node previous;
		Node next;

		public Node(int key, int value) {
			this.key = key;
			this.data = value;
		}
	}

	int capacity;
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	Node head = null;
	Node tail = null;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			remove(n);
			setHead(n);
			return n.data;
		}

		return -1;
	}

	public void remove(Node n) {
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

	public void setHead(Node n) {
		if (head == null) {
			tail = n;
		} else {
			head.previous = n;
		}
		n.next = head;
		head = n;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node old = map.get(key);
			old.data = value;
			remove(old);
			setHead(old);
		} else {
			Node created = new Node(key, value);
			if (map.size() >= capacity) {
				map.remove(tail.key);
				remove(tail);
			}

			setHead(created);
			map.put(key, created);
		}
	}

	public static void main(String[] args) {
		LRUCache c = new LRUCache(5);
		c.set(1, 100);
		c.set(2, 200);
		c.set(3, 300);
		c.set(4, 400);
		c.set(5, 500);
		c.set(6, 600);
		c.set(2, 500);

		System.out.println(c.get(2));
		System.out.println(c.get(1));

	}
}
