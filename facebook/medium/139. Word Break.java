// medium


// DP, 没想到
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        // init
        // 若不是true，若s中substring(0,1)在字典中，就会出错
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++)
        {
            for (int j = 0; j < i; j++)
            {
                // substring(0, j) and substring(j, i) 都在字典中
                if (dp[j] && wordDict.contains(s.substring(j, i)))
                {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
