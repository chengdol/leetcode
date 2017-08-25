// easy

class Solution {
    public double findMaxAverage(int[] nums, int k) {

        double curSum = 0;
        // init
        for (int i = 0; i < k; i++) { curSum += nums[i]; }

        double maxSum = curSum;
        int start = 0;
        int end = k;

        // sliding window
        while (end < nums.length)
        {
            curSum = curSum - nums[start++] + nums[end++];
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum / k;
    }
}
