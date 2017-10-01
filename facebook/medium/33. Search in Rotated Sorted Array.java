// medium

class Solution {
    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        // no duplicates in array!
        while (l <= r)
        {
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) { return mid; }
            // smaller
            if (target < nums[mid])
            {
                // special case
                if (nums[r] < nums[mid] && target <= nums[r])
                {
                    l = mid + 1;
                }
                else
                {
                    r =  mid - 1;
                }
            }
            // larger
            else
            {
                // special case
                if (nums[l] > nums[mid] && target >= nums[l])
                {
                    r = mid - 1;
                }
                else
                {
                    l = mid + 1;
                }
            }
        }

        return -1;
    }
}
