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
