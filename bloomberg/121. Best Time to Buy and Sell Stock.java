// easy

// 一般思路，低买高卖
class Solution {
    public int maxProfit(int[] prices)
    {
        int min = Integer.MAX_VALUE;
        // init min profit as 0
        int profit = 0;

        for (int i = 0; i < prices.length; i++)
        {
            // 只需计算一个分支，后面价格大才需要update profit
            if (i != 0 && prices[i] > prices[i - 1])
            {
                 profit = Math.max(profit, prices[i] - min);
            }
            else
            {
                min = Math.min(min, prices[i]);
            }
        }

        return profit;
    }
}

// 当做max subarray sum来解决
//  Kadane's Algorithm
// 类似于suffix sum那个算法, 关键是判断num[i]是否包含在max subarray中！
class Solution {
    public int maxProfit(int[] prices)
    {
        if (prices == null || prices.length < 2) { return 0; }
        // prices at least has 2 entries
        int[] diff = new int[prices.length - 1];
        // init
        for (int i = 1; i < prices.length; i++)
        {
            diff[i - 1] = prices[i] - prices[i - 1];
        }

        int max_profit = diff[0];
        int cur_profit = max_profit;
        for (int i = 1; i < diff.length; i++)
        {
            // only compare diff[i] and diff[i] + prefix sum
            cur_profit = Math.max(diff[i], cur_profit + diff[i]);
            max_profit = Math.max(max_profit, cur_profit);
        }

        return max_profit < 0? 0 : max_profit;
    }
}
