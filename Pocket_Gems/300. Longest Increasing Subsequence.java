// medium


class Solution {
    public int lengthOfLIS(int[] nums)
    {
        if (nums == null || nums.length == 0) { return 0; }

        // dp[i] means longest # of increasing subsequence from 0 to i index
        int[] dp = new int[nums.length];
        // init
        dp[0] = 1;
        // at least 1
        int maxLen  = 1;
        for (int i = 1; i < nums.length; i++)
        {
            int curLen = 0;
            for (int j = 0; j < i; j++)
            {
                // 若nums[j]可能不是dp[j]最长序列的最后一个值，但一定会包含，所以这个条件判断是对的
                if (nums[j] < nums[i] && dp[j] > curLen)
                {
                    curLen = dp[j];
                }
            }
            dp[i] = curLen + 1;
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }
}
