// easy

// in-place
class Solution {
    public void moveZeroes(int[] nums)
    {
        // new index for non-zero element
        int i = 0;
        for (int j = 0; j < nums.length; j++)
        {
            if (nums[j] != 0) { nums[i++] = nums[j]; }
        }
        // assign 0 to rest of i element
        while (i < nums.length) { nums[i++] = 0; }
    }
}
