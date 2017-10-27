// medium

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

// O(n) space by using hashmap(old, new)
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head)
    {
        if (head == null) { return null; }
        // key old node, value new node referenec
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        // copy the list node
        RandomListNode p = head;
        while (p != null)
        {
            RandomListNode newNode = new RandomListNode(p.label);

            map.put(p, newNode);
            p = p.next;
        }

        // link for next and random
        for (Map.Entry<RandomListNode, RandomListNode> e : map.entrySet())
        {
            RandomListNode n = e.getValue();
            // connect
            n.next = map.get(e.getKey().next);
            n.random = map.get(e.getKey().random);
        }

        // here return map.get(head) is also ok
        return map.get(head);
    }
}



// O(1) extra space, 这个方法好，没想到
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head)
    {
        if (head == null) { return null; }

        // 第一次遍历
        // create new node and connect it right after the original one
        RandomListNode p = head;
        while (p != null)
        {
            RandomListNode n = new RandomListNode(p.label);
            // connect
            RandomListNode next = p.next;
            p.next = n;
            n.next = next;

            p = next;
        }

        // 第二次遍历
        // set random link for copied node
        p =  head;
        while (p != null)
        {
            RandomListNode random = p.random;
            if (random != null)
            {
                p.next.random = random.next;
            }
            p = p.next.next;
        }

        // 第三次遍历
        // extract copied list and restore original input
        RandomListNode newHead = head.next;
        RandomListNode ph = newHead;
        p = head;
        while (p != null)
        {
            p.next = p.next.next;
            if (ph.next != null)
            {
                ph.next = ph.next.next;
            }

            p = p.next;
            ph = ph.next;
        }

        return newHead;
    }
}
