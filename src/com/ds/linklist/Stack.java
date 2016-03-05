package com.ds.linklist;

// using static method here unlike queue
// 4----> 3----> 2----> 1 --->
// top

public class Stack {
	ListNode top;

	public ListNode pop() {
		if (top == null) {
			return null;
		}
		ListNode tmp = top;
		top = top.next;
		return tmp;
	}

	public void push(int d) {
		ListNode tmp = new ListNode(d);
		tmp.next = top;
		top = tmp;
	}

	public void print() {
		ListNode current = top;
		while (current != null) {
			System.out.print(current.data + "--->");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Stack obj = new Stack();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);

		obj.print();
		System.out.print("popped element:" + obj.pop().data + "   ");
		obj.print();
		System.out.print("popped element:" + obj.pop().data + "   ");
		obj.print();
		System.out.print("popped element:" + obj.pop().data + "   ");
		obj.print();
		System.out.print("popped element:" + obj.pop().data + "   ");
		obj.print();
		System.out.print("popped element:" + (obj.pop() != null ? obj.pop().data : " " + "   "));
		obj.print();
	}
}
