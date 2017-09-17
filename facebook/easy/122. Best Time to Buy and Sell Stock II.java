// easy

// 和现实一样的场景，只做有利可图的一段，叠加所有利润即可
class Solution {
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 1) { return 0; }

        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++)
        {
            maxProfit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return maxProfit;
    }
}
