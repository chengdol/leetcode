// medium

class Solution {
    public int uniquePaths(int m, int n)
    {
        // specail case
        if (m == 1 || n == 1) { return 1; }

        // dp[i][j] means the total unique path arrives at [i][j] point
        int[][] dp = new int[m][n];
        // init first column and row
        for (int i = 0; i < m; i++) { dp[i][0] = 1; }
        for (int i = 0; i < n; i++) { dp[0][i] = 1; }

        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        return dp[m - 1][n - 1];
    }
}
