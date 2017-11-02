// medium


// 自己写的好理解一些
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        int[][] ob = obstacleGrid;
        int[] dp = new int[ob[0].length];
        // init
        // 遇到1，后面的都走不通了
        for (int i = 0; i < ob[0].length; i++)
        {
            if (ob[0][i] == 0) { dp[i] = 1; }
            else { break; }
        }

        for (int k = 1; k < ob.length; k++)
        {
            for (int i = 0; i < dp.length; i++)
            {
                if (i == 0)
                {
                    // 如果ob[k][i]不是1，dp[0]都继承的上一次的dp[0]
                    dp[i] = ob[k][i] == 1? 0 : dp[i];
                    continue;
                }

                if (ob[k][i] == 1) { dp[i] = 0; }
                else
                {
                    dp[i] += dp[i - 1];
                }
            }
        }


        return dp[dp.length - 1];
    }
}
