// medium

// binary search
class Solution {
    public int search(int[] nums, int target)
    {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) { return mid; }
            else if (nums[mid] > target)
            {
                // special case
                if (nums[mid] > nums[hi] && target <= nums[hi])
                {
                    lo = mid + 1;
                }
                else
                {
                    hi = mid - 1;
                }
            }
            else
            {
                // special case
                if (nums[mid] < nums[lo] && target >= nums[lo])
                {
                    hi = mid - 1;
                }
                else
                {
                    lo = mid + 1;
                }
            }
        }

        return -1;
    }
}
