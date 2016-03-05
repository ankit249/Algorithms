package com.ds.hashtable;

public class SeperateChaining {

	int MAX = 50;
	int hasharraysize = MAX * 2;
	Node array[] = new Node[hasharraysize];

	public class Node {
		int data;
		String d;
		Node next;;

		Node(int d) {
			this.data = d;
			this.next = null;
		};

		Node(String x) {
			this.d = x;
		}

	}

	// returns hashcode
	public int hashcode(String string) {
		int hash = 0;
		for (int i = 0; i < string.length(); i++) {
			hash = (int) string.charAt(i) + 31 * hash;
		}

		return hash;
	}

	// return hash of the string
	public int hash(String string) {
		return (hashcode(string) & 0x7fffffff) % hasharraysize;
	}

	public static void main(String[] args) {
		SeperateChaining obj = new SeperateChaining();
		obj.put("ankit");
	}

	private void put(String string) {
		int index = hash(string);
		Node current = null;
		for (Node x = array[index]; x != null; x = x.next) {
			current = x;
		}
		current.next = new Node(string);
	}

}
