// medium


class Solution {
    public int maxProfit(int[] prices, int fee)
    {
        // profit with no stack
        int s0 = 0;
        // profit with 1 stack
        // init买了prices[1]
        int s1 = -prices[0] - fee;

        for (int i = 0; i < prices.length; i++)
        {
            int tmp = s0;
            // 这里s1 + prices[i] - fee 可能会overflow
            // s0表示没有stock，就是把上次的stock卖了，取最大值
            s0 = Math.max(s0, s1 + prices[i]);
            // si表示有stock，应该在上次s0的基础上买
            s1 = Math.max(s1, tmp - prices[i] - fee);
        }

        return s0;
    }
}
