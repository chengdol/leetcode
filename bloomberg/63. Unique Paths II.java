// medium


class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] ob = obstacleGrid;
        int h = ob.length;
        int w = ob[0].length;

        int[] dp = new int[w];
        // init
        // 起始
        dp[0] = 1;

        for (int i = 0; i < h; i++)
        {
            for (int j = 0; j < w; j++)
            {
                if (ob[i][j] == 1)
                {
                    dp[j] = 0;
                }
                else if (j > 0)
                {
                    // dp[j]是上一行的,dp[j-1]是当前行的
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }

        return dp[w - 1];
    }
}
