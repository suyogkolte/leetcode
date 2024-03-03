// This file contains operations like
// 1] creating a LL,
// 2] adding an element at the head,
// 3] adding an element at the tail
// 4] adding an element in the middle
// 5] delete an element at the head
// 6] delete an element at the tail
// 7] delete an element in the middle

import java.util.List;

/** Definition for singly-linked list. */
public class ListNode {
    int val;
    ListNode next = null;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void printList(ListNode head) {
        System.out.println("--------------------------------------------------");
        if(head == null)
            System.out.println("The given list is empty");
        else {
            ListNode curr = head;
            while(curr != null) {
                System.out.println(curr.val);
                curr = curr.next;
            }
        }
    }

    public ListNode addAtHead(ListNode head, int val) {
        ListNode node = new ListNode(val);
        if(head == null)
            return node;

        node.next = head;
        head = node;
        return head;
    }

    public ListNode addAtTail(ListNode head, int val) {
        ListNode node = new ListNode(val);
        if(head == null)
            return node;

        ListNode curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }

        curr.next = node;
        return head;
    }

    public ListNode addAtMiddle(ListNode head, int val) {
        ListNode node = new ListNode(val);
        if(head == null)
            return node;

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        node.next = slow.next;
        slow.next = node;
        return head;
    }

    public ListNode deleteAtHead(ListNode head) {
        if(head == null)
            return null;

        return head.next;
    }

    public ListNode deleteAtTail(ListNode head) {
        if(head == null || head.next == null)
            return null;

        ListNode curr = head;
        while(curr.next != null && curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }

    public ListNode deleteAtMiddle(ListNode head) {
        if(head == null)
            return null;

        ListNode slow = head;
        ListNode prev = null;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head = head.addAtTail(head, 2);
        head = head.addAtTail(head, 3);
        head = head.addAtTail(head, 4);
        head = head.addAtTail(head, 5);
        head = head.addAtHead(head, 10);
        head = head.addAtMiddle(head, 15);
        printList(head);
        head = head.deleteAtMiddle(head);
        printList(head);
        head = head.deleteAtMiddle(head);
        printList(head);
        head = head.deleteAtTail(head);
        printList(head);
        head = head.deleteAtHead(head);
        printList(head);
    }
}

