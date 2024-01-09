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
class Solution1 {
    // Iterative solution
    public ListNode reverseList(ListNode head) {
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
}

class Solution2 {
    // Recursive solution
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
        {
            return head;
        }

        ListNode p = reverseList(head.next);

        head.next.next = head;
        head.next = null;
        return p;
    }
}