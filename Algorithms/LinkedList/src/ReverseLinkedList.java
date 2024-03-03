// Source : https://leetcode.com/problems/reverse-linked-list/

import java.util.List;

class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;

        System.out.println("Original LL is: ");
        ListNode.printList(head);
        System.out.println();

        //System.out.println("Iteratively Reversed LL is:");
        //ListNode.printList(reverseListIterative(head));

        System.out.println("Recursively Reversed LL is:");
        printLinkedList(reverseListRecursive(head));

    }

    public static ListNode reverseListIterative(ListNode head) {
        if(head == null)
            return head;

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null)
        {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }

    public static ListNode reverseListRecursive(ListNode head) {
        if(head == null || head.next == null)
        {
            return head;
        }

        ListNode p = reverseListRecursive(head.next);

        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void printLinkedList(ListNode head) {
        ListNode curr = head;
        while(curr != null){
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
}