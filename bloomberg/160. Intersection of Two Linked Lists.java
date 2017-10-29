// easy


// using O(1) space
// 没思路

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// O(n) time, O(1) space
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        if (headA == null || headB == null) { return null; }

        // get the length of two list
        int lenA = length(headA);
        int lenB = length(headB);

        // align the two list, set new start point for the longer list
        while (lenA > lenB)
        {
            headA = headA.next;
            lenA--;
        }

        while (lenB > lenA)
        {
            headB = headB.next;
            lenB--;
        }

        // find the intersection or not
        while (headA != headB)
        {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;

    }

    private int length(ListNode p)
    {
        int len = 0;
        while (p != null)
        {
            len++;
            p = p.next;
        }
        return len;
    }
}
