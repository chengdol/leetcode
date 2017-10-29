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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode head = new ListNode(0);
        ListNode p = head;

        int carrier = 0;
        while (l1 != null || l2 != null)
        {
            int sum = 0;
            sum += carrier;

            if (l1 != null)
            {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null)
            {
                sum += l2.val;
                l2 = l2.next;
            }

            if (sum >= 10) { sum -= 10; carrier = 1; }
            else { carrier = 0;}

            p.next = new ListNode(sum);
            // update position
            p = p.next;
        }
        // carrier
        if (carrier == 1) { p.next = new ListNode(1); }

        return head.next;
    }
}
