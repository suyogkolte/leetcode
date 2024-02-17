// Source : https://leetcode.com/problems/reverse-linked-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ReverseLinkedList {
    // Iterative solution
    public ListNode reverseListIterative(ListNode head) {
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

    // Recursive solution
    public ListNode reverseListRecursive(ListNode head) {
        if(head == null || head.next == null)
        {
            return head;
        }

        ListNode p = reverseListRecursive(head.next);

        head.next.next = head;
        head.next = null;
        return p;
    }
}