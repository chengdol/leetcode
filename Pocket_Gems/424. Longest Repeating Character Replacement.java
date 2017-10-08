// medium


// 不太好理解
class Solution {
    public int characterReplacement(String s, int k)
    {
        int maxCnt = 0;
        int maxLen = 0;
        int[] freq = new int[26];

        int lo = 0;
        for (int hi = 0; hi < s.length(); hi++)
        {
            // 更新当前char的频率，记录最大值
            maxCnt = Math.max(maxCnt, ++freq[s.charAt(hi) - 'A']);
            // 不满足K的要求了，这里若lo对应的是most freq的，则maxCnt会变
            // 但不影响，window只管右移，直到出现新的maxCnt，则maxLen才会变大
            if (hi - lo + 1 - maxCnt > k)
            {
                freq[s.charAt(lo) - 'A']--;
                // lo move right
                lo++;
            }
            // hi没移动一次都检查了maxLen
            maxLen = Math.max(maxLen, hi - lo + 1);
        }
        return maxLen;
    }
}
