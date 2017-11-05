// medium


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head)
    {
        ListNode DummyHead = new ListNode(0);
        DummyHead.next = head;

        ListNode p = DummyHead;
        while (p.next != null && p.next.next != null)
        {
            // swap 接下来的2个node
            ListNode tmp = p.next.next;
            p.next.next = tmp.next;
            tmp.next = p.next;
            p.next = tmp;

            // update p pointer
            p = p.next.next;
        }

        return DummyHead.next;
    }
}
