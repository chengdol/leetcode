// easy


// DP version
// DP 比较好理解
class Solution {
    public int maxProfit(int[] prices)
    {
        if (prices == null || prices.length == 0) { return 0; }
        // 这里长度不是prices.length + 1
        int[] dp = new int[prices.length];
        // init, no buy and sell
        dp[0] = 0;

        int min = prices[0];
        for (int i = 1; i < prices.length; i++)
        {
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            // update min price from 0 ~ i;
            min = Math.min(min, prices[i]);
        }

        return dp[prices.length - 1];
    }
}
// 也可以不用DP
class Solution {
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 1) { return 0; }

        int min = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++)
        {
            maxProfit = Math.max(maxProfit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return maxProfit;
    }
}
// 这题其实可以变化为max subarray problem, 将prices array -> profits array

