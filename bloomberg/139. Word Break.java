// medium


// dp
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) 
    {
        boolean[] dp = new boolean[s.length() + 1];
        // init
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++)
        {
            for (String w : wordDict)
            {
                if (i >= w.length() && dp[i - w.length()])
                {
                    // substring这里要注意限制长度！
                    dp[i] = s.substring(i - w.length(), i).equals(w);
                    // 一旦为真，break
                    if (dp[i]) { break; }
                }
                
            }
        }
        
        return dp[s.length()];
    }
}