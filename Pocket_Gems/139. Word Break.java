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

// DP 我想到了
class Solution {
    public boolean wordBreak(String s, List<String> wordDict)
    {
        boolean[] dp = new boolean[s.length() + 1];
        // init, 为什么呢？ 因为后面会用到dp[0]，如果是false，没意义了
        // 并且递归的时候，终止条件也是长度为零返回true
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++)
        {
            for (String w : wordDict)
            {
                // if dp[i - w.length()] is false, no need to calc
                // once dp[i] is true, done, go to next i
                if (i >= w.length() && dp[i - w.length()] && !dp[i])
                {
                    dp[i] = s.startsWith(w, i - w.length());
                }
            }
        }
        return dp[s.length()];
    }
}
