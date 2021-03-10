package com.ds.linklist;

public class MiddleOfLinkedList {
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

    // TC - O(n), SC - O(1)
    public ListNode findMid(ListNode head) {
        if(head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
        }

        return slow;
    }


    public static void main(String[] args) {

        // even nummber of elements - use second middle node
        MiddleOfLinkedList list = new MiddleOfLinkedList();
        ListNode head = new ListNode(1);
        list.add(head, 2);
        list.add(head, 3);
        list.add(head, 4);
        list.add(head, 5);
        list.add(head, 6);
        //list.add(head, 7);

        list.print(head);

        ListNode mid = list.findMid(head);
        System.out.println(mid.data);


    }

}
