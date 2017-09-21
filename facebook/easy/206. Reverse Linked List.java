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

    ListNode root = null;
    public ListNode reverseList(ListNode head) {

        helper(head);
        return root;
    }

    private ListNode helper(ListNode n)
    {
        if (n == null) { return null; }
        if (n.next == null) { root = n; return n; }

        // 这里是关键
        helper(n.next).next = n;
        n.next = null;
        return n;
    }
}
