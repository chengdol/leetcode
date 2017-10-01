// medium


class Solution {
    public int countSubstrings(String s) {

        if (s == null || s.isEmpty()) { return 0; }

        int len = s.length();
        int[][] dp = new int [len][len];
        // init
        for (int i = 0; i < len; i++) { dp[i][i] = 1; }

        // fragment length
        for (int k = 1; k < len; k++)
        {
            // substring start index
            for (int i = 0; i + k < len; i++)
            {
                dp[i][i + k] = dp[i][i + k - 1] + dp[i + 1][i + k];
                if (k > 1)
                {
                    dp[i][i + k] -= dp[i + 1][i + k - 1];
                }
                // 直接使用s 比用substring 快很多
                dp[i][i + k] += isPalindrom(s, i, i + k);
            }
        }

        return dp[0][len - 1];
    }

    private int isPalindrom(String s, int l, int r)
    {
        while (l < r)
        {
            if (s.charAt(l) != s.charAt(r)) { return 0; }
            l++;
            r--;
        }
        return 1;
    }

}
