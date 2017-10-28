// easy


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private ListNode head;

    public ListNode reverseList(ListNode head)
    {
        reverse(head);
        return this.head;
    }

    private ListNode reverse(ListNode n)
    {
        if (n == null) { return null; }
        if (n.next == null) { head = n; return n; }

        ListNode pre = reverse(n.next);
        pre.next = n;
        n.next = null;

        return n;
    }
}
