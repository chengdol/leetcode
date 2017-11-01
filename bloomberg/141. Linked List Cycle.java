// easy


public class Solution {
    public boolean hasCycle(ListNode head) 
    {
     
        if (head == null) { return false; }
        
        ListNode slow = head;
        ListNode fast = head;
        
        do 
        {
            slow = slow.next;
            
            fast = fast.next;
            if (fast != null)
            {
                fast = fast.next;
            }
        }while (slow != fast && fast != null);
        
        return slow == fast && fast != null;
        
    }
}