// medium

// PQ的方法还是和能巧妙的
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        Queue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        // init
        for (ListNode n : lists)
        {
            if (n != null) { pq.offer(n); }
        }

        ListNode head = new ListNode(0);
        ListNode ptr = head;
        while (!pq.isEmpty())
        {
            ptr.next = pq.poll();
            ptr = ptr.next;

            if (ptr.next != null) { pq.offer(ptr.next); }
        }

        return head.next;
   }
}
