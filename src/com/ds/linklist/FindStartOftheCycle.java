package com.ds.linklist;


/**
 *    1 > 2 > 3 > 4 > 5
 *        ^
 *        |           |
 *         -----------
 */
public class FindStartOftheCycle {
    public void add(ListNode head, int data) {
        ListNode tmp = new ListNode(data);
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = tmp;
    }

    public static void print(ListNode p) {
        ListNode current = p;
        while (current != null) {
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.println();
    }

    // TC - O(n), SC- O(1)
    private static ListNode findStartOfCycle(ListNode head) {

        if (head == null) // list does not exist..so no loop either.
            return null;

        ListNode slow = head; // create two references.
        ListNode fast = head; // make both refer to the start of the list.

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return walk(slow, head);
            }
        }

        return null;
    }

    private static ListNode walk(ListNode slow, ListNode head) {
        ListNode secondSlow = head;

        while(slow != secondSlow) {
            slow = slow.next;
            secondSlow = secondSlow.next;
        }
        return slow;
    }

    public static void main(String[] args) {

        // even nummber of elements - use second middle node
        CircleDetectionLengthOfLoop list = new CircleDetectionLengthOfLoop();


        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        /* Create a loop for testing */
        head.next.next.next.next.next = head.next;
        // infinite loop
        //print(head);

        ListNode result = findStartOfCycle(head);

        System.out.println( result.data);
    }
}
