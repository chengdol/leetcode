// easy

// 我以前用的princeton中一种使用hash匹配字符串的方法，太复杂了
// 这题就是让我们实现indexof()
// 用最原始的操作
class Solution {
    public int strStr(String haystack, String needle)
    {
        if (haystack == null || needle == null || needle.length() > haystack.length()) { return -1; }
        if (needle.isEmpty()) { return 0; }

        // i <= insteaf of <, 比如"a" "a"
        for (int i = 0; i <= haystack.length() - needle.length(); i++)
        {
            int cnt = 0;
            for (int j = i; j < needle.length() + i; j++)
            {
                if (haystack.charAt(j) != needle.charAt(j - i)) { break; }
                cnt++;
            }
            if (cnt == needle.length()) { return i; }
        }

        return -1;
    }
}

// KMP
class Solution {
    public int strStr(String haystack, String needle)
    {
        if (needle.isEmpty()) { return 0; }

        int[] next = new int[needle.length()];
        // create KMP next table
        int i = 0;
        for (int j = 1; j < needle.length(); )
        {
            if (needle.charAt(i) == needle.charAt(j))
            {
                next[j] = i + 1;
                i++;
                j++;
            }
            else
            {
                // 构造的时候这里错了, 注意是i的变化不是j
                if (i > 0 && needle.charAt(i) != needle.charAt(j)) { i = next[i - 1]; }
                else if (i == 0 && needle.charAt(i) != needle.charAt(j))
                {
                    next[j] = 0;
                    j++;
                }
                else
                {
                    next[j] = i + 1;
                    j++;
                    i++;
                }
            }
        }

        i = 0;
        int j = 0;
        while (i < haystack.length())
        {
            if (haystack.charAt(i) == needle.charAt(j))
            {
                i++;
                j++;
            }

            // return start index
            if (j == needle.length()) { return i - j; }

            else if (i < haystack.length() && haystack.charAt(i) != needle.charAt(j))
            {
                // 这里j可能会往回走几次
                if (j != 0) { j = next[j - 1]; }
                // 上一次j = 0时，已经判断或了，这是第二次j = 0，说明s[i]确实不相等，可以后移了
                else { i++; }
            }

        }
        return -1;
    }
}
