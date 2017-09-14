// easy

class Solution {
    public void moveZeroes(int[] nums) {

        if (nums == null || nums.length <= 1) { return; }

        int idx = 0;
        for (int n : nums)
        {
            if (n != 0) { nums[idx++] = n; }
        }

        while (idx < nums.length) { nums[idx++] = 0; }
    }
}
