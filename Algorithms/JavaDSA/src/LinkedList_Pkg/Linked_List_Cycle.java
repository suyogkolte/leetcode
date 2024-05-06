// Source: https://leetcode.com/problems/linked-list-cycle/description/
package LinkedList_Pkg;

public class Linked_List_Cycle{
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;
        node3.next = node1;

        if(Linked_List_Cycle.hasCycle(head))
            System.out.println("There is a cycle present in the given linked list");
        else
            System.out.println("There is no cycle present in the given linked list");
    }

    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                return true;
        }
        return false;
    }
}