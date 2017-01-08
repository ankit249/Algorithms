package com.ds.hashtable;

//     ____    
//    |____|-->|key|data| -->  |key|data|
//    |____|   
//    |____|
//    |____|
//

class Node {
	int key;
	int data;
	Node next;

	Node(int key, int data) {
		this.key = key;
		this.data = data;
		this.next = null;

	}
}

public class CustomHashMap {
	int capacity;
	Node[] arr;

	public CustomHashMap(int capacity) {
		this.capacity = capacity;
		arr = new Node[capacity];
	}

	public int hashcode(int key) {
		return key % capacity;
	}

	public int get(int key) {
		int hashcode = hashcode(key);
		Node head = arr[hashcode];
		Node current = head;
		while (current != null) {
			if (current.key == key) {
				return current.data;
			}
			current = current.next;
		}

		// System.out.println("not found");

		return -1;
	}

	public void put(int key, int data) {
		int hashcode = hashcode(key);

		Node tmp = new Node(key, data);

		if (arr[hashcode] == null) {
			arr[hashcode] = tmp;
		} else {
			Node prev = null;
			Node current = arr[hashcode];
			while (current != null) {
				if (current.key == key) {
						current.data = data;
						return;
				}
				prev = current;
				current = current.next;
			}
			prev.next = tmp;
		}
	}

	public static void main(String[] args) {
		CustomHashMap c = new CustomHashMap(4);
		c.put(100, 100);
		c.put(100, 200);
		c.put(48, 121);
		c.put(47, 921);
		c.put(51, 200);
		c.put(51, 300);

		System.out.println(c.get(100));
		System.out.println(c.get(48));
		System.out.println(c.get(47));
		System.out.println(c.get(51));

		System.out.println(c.get(10));
		System.out.println(c.get(51));
	}

}
