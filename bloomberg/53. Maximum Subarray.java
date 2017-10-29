// easy

class Solution {
    // Kadane's algorithm
    public int maxSubArray(int[] nums)
    {
        if (nums == null) { return 0; }

        int maxSum = nums[0];
        int prefixSum = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            // include nums[i] in max sub array?
            prefixSum = Math.max(prefixSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, prefixSum);
        }

        return maxSum;
    }
}
