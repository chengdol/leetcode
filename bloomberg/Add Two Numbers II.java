// medium


// 面经见过这题
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
        Deque<ListNode> stack1 = new LinkedList<>();
        Deque<ListNode> stack2 = new LinkedList<>();

        // push
        while (l1 != null)
        {
            stack1.push(l1);
            l1 = l1.next;
        }

        while (l2 != null)
        {
            stack2.push(l2);
            l2 = l2.next;
        }

        // pop node from stack and build final result
        List<ListNode> res = new ArrayList<>();
        int carrier = 0;
        int operand1 = 0;
        int operand2 = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty())
        {
            if (!stack1.isEmpty() && !stack2.isEmpty())
            {
                operand1 = stack1.pop().val;
                operand2 = stack2.pop().val;
            }
            else if (!stack1.isEmpty())
            {
                operand1 = stack1.pop().val;
                operand2 = 0;
            }
            else
            {
                operand1 = 0;
                operand2 = stack2.pop().val;
            }

            int sum = operand1 + operand2 + carrier;
            if (sum >= 10) { sum -= 10; carrier = 1; }
            else { carrier = 0; }

            ListNode n = new ListNode(sum);
            // insert at head
            res.add(0, n);
        }
        // check carrier
        if (carrier != 0)
        {
            res.add(0, new ListNode(1));
        }

        // form linked list
        // dummy head
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i = 0; i < res.size(); i++)
        {
            p.next = res.get(i);
            p = p.next;
        }

        // return
        return head.next;
    }



}
