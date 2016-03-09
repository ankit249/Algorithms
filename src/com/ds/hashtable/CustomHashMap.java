package com.ds.hashtable;

//     ____    
//    |____|-->|key|value| -->  |key|value|
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
	int capacity = 4;
	Node[] arr = new Node[capacity];

	public int hashcode(int key) {
		return key % capacity;
	}

	public Node get(int key) {
		int hashcode = hashcode(key);
		Node head = arr[hashcode];
		Node current = head;
		while (current != null) {
			if (current.key == key) {
				return current;
			}
			current = current.next;
		}

		System.out.println("not found");

		return null;
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
					if (prev == null) { // head
						// no need to set previous pointer
						tmp.next = current.next;
						arr[hashcode] = tmp;
						return;
					} else {
						current.data = data;
						return;
					}
				}

				prev = current;
				current = current.next;
			}
			prev.next = tmp;
		}
	}

	public static void main(String[] args) {
		CustomHashMap c = new CustomHashMap();
		c.put(100, 100);
		c.put(48, 200);
		c.put(47, 200);
		c.put(51, 200);
		c.put(51, 300);

		System.out.println(c.get(100).data);
		System.out.println(c.get(48).data);
		System.out.println(c.get(47).data);
		System.out.println(c.get(51).data);

		System.out.println(c.get(10));
		System.out.println(c.get(51).data);
	}

}
