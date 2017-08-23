// medium

class Solution {
    public int findLongestChain(int[][] pairs) {

        if (pairs == null || pairs.length == 0 || pairs[0].length == 0) { return 0; }
        // sort based on first number
        Arrays.sort(pairs, (int[] a, int[] b)-> a[0] - b[0]);

        // dp[i] means  0 ~ i-1 longest chaining number
        int[] dp = new int[pairs.length];
        // init, at least has 1 pair
        Arrays.fill(dp, 1);

        for (int i = 0; i < dp.length; i++)
        {
            // 每次从头开始更新dp[i]
            for (int j = 0; j < i; j++)
            {
                dp[i] = Math.max(dp[i], pairs[i][0] > pairs[j][1]? dp[j] + 1 : dp[j]);
            }
        }

        return dp[pairs.length - 1];
    }
}
