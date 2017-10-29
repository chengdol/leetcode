// medium


// the same as 142. Linked List Cycle II
class Solution {
    public int findDuplicate(int[] nums)
    {
        int slow = nums[0];
        int fast = nums[nums[0]];
        // find circle
        while (slow != fast)
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // start from index 0
        // move one each step
        fast = 0;
        while (fast != slow)
        {
            slow = nums[slow];
            fast = nums[fast];
        }
        // when meet, that point is circle entry, thus the duplicate
        return slow;
    }
}





