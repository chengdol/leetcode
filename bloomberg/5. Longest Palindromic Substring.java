// medium


class Solution
{
    private int start = 0;
    private int maxLen = 0;

    public String longestPalindrome(String s)
    {
        if (s == null || s.length() < 2) { return s; }

        for (int i = 0; i < s.length() - 1; i++)
        {
            extendString(s, i, i); // for odd
            extendString(s, i, i + 1); // for even string
        }

        return s.substring(start, start + maxLen);
    }

    private void extendString(String s, int i, int j)
    {
        // 从起始点向两边扩展
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j))
        {
            i--;
            j++;
        }
        if (maxLen < j - i - 1)
        {
            start = i + 1;
            maxLen = Math.max(maxLen, j - i - 1);
        }
    }
}
