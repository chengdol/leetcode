// medium

public class Solution {
    public int findTargetSumWays(int[] nums, int S) {

        if (nums == null) { return 0; }

        int sum = 0;
        // special cases
        for (int n : nums) { sum += n; }
        // 这里不要写错了
        if (S < -sum || S > sum) { return 0; }

        // dp[i][j] means from nums[0~i], 有多少种方式组合得到j
        // j should be -sum ~ sum， 这里必须转成正的index, 比如-5 ~ 5一共有11 个数
        int[][] dp = new int[nums.length + 1][2*sum + 1];

        // init
        // 偏移加上,代表0个元素 的组合值 是 0， 有一种组合方式
        dp[0][0 + sum] = 1;

        // 这里i是个数
        for (int i = 1; i <= nums.length; i++)
        {
            for (int j = 0; j < 2 * sum + 1; j++)
            {
                // 得到目标值，相当于上一个组合值加上nums[i - 1]可以得到j
                if (j - nums[i - 1] >= 0)
                {
                   dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
                // 得到目标值, 相当于上一个组合值减去nums[i - 1]可以得到j
                if (j + nums[i - 1] < (2 * sum + 1))
                {
                    dp[i][j] += dp[i - 1][j + nums[i - 1]];
                }
            }
        }

        // 因为我们要的是S，sum在这里是偏移
        return dp[nums.length][sum + S];
    }
}
