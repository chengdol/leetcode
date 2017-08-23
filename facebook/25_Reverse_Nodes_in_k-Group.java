// hard

// require constant time solution
// recursive version
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        return helper(head, k);
    }

    private ListNode helper(ListNode head, int k)
    {
        if (head == null || k <= 1) { return head; }

        ListNode cur = head;
        int cnt = 0;
        // count node number and point to the next head
        // otherwise we cannot reverse the list
        // 3->2->1->x->....
        // 若要reverse3->..->1则必须知道1.next
        while (cur != null && cnt < k)
        {
            cur = cur.next;
            cnt++;
        }

        // 该group可以reverse
        if (cnt == k)
        {
            // reverse next group nodes and return the new head of next group
            cur = helper(cur, k);

            // reverse current group
            // 注意是怎么reverse的
            while (cnt-- > 0)
            {
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }

            head = cur;
        }

        return head;
    }
}

//=================================================================
// iterative version
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k <= 1) { return head; }

        // dummy head
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // count length of this linkedlist
        int len = 0;
        while (head != null) { head = head.next; len++; }

        // 注意pre, cur, nex这3个指针是怎么工作的，见例图
        ListNode pre = dummy;
        while (len >= k)
        {
            ListNode cur = pre.next;
            ListNode nex = cur.next;

            // 翻转2个节点只需一次操作，所以从1开始
            for (int i = 1; i < k; i++)
            {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            // update pre
            pre = cur;
            len -= k;
        }

        return dummy.next;
    }

}







