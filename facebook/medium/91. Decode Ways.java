// medium

public class Solution {
    public int numDecodings(String s) {
        // invalid sequence
        if (s == null || s.length() <= 0 || s.charAt(0) == '0') { return 0; }

        int[] dp = new int[s.length() + 1];
        // init
        // empty string decode way is 0，这里设置为1是为了dp后面的正确性
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= s.length(); i++)
        {
            // i is not index of s, it is length of s
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));

            // 注意没有dp[i] = dp[i - 1] + 1; 因为新增一个数，对decode way没有影响
            if (oneDigit >= 1 && oneDigit <= 9) { dp[i] += dp[i - 1]; }
            if (twoDigit >= 10 && twoDigit <= 26) { dp[i] += dp[i - 2]; }

        }

        return dp[s.length()];
    }
}