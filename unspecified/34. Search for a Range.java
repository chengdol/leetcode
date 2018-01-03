// medium


/*
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

// 简单的binary search

class Solution {
    public int[] searchRange(int[] nums, int target) 
    {
        int[] ret = {-1, -1};
        // find left boundary
        ret[0] = find(nums, target, true);
        // find right boundary
        ret[1] = find(nums, target, false);
        return ret;
    }
    
    private int find(int[] nums, int target, boolean left)
    {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target)
            {
                // search left index
                if (left)
                {
                    // corner case
                    if (mid - 1 < 0 || mid - 1 >= 0 && nums[mid - 1] != target) { return mid; }
                    else { hi = mid - 1; }
                }
                // search right index
                else
                {
                    // corner case
                    if (mid + 1 >= nums.length || mid + 1 < nums.length && nums[mid + 1] != target) { return mid; }
                    else { lo = mid + 1; }
                }
            }
            else if (nums[mid] > target)
            {
                hi = mid - 1;
            }
            else
            {
                lo = mid + 1;
            }
        }
        // no found
        return -1; 
    }
}