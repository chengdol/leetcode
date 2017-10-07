// hard


// 从后往前找最长的palindrome O(n^2)
class Solution {
    public String shortestPalindrome(String s)
    {
        // The idea is to find the longest palindromic prefix(start from index 0) of given string.
        // 倒着找，找到就break
        int i = s.length() - 1;
        while (i >= 0)
        {
            if (isPalindrome(s, i)) { break; }
            i--;
        }

        return new StringBuilder(s.substring(i + 1)).reverse().toString() + s;
    }

    private boolean isPalindrome(String s, int j)
    {
        int i = 0;
        while (i < j)
        {
            if (s.charAt(i++) != s.charAt(j--)) { return false; }
        }
        return true;
    }
}

// KMP O(n)
// 关键是怎么构造lookup table
class Solution {
    public String shortestPalindrome(String s)
    {
        // & used to force scan from index 0
        String tmp = s + "&" + new StringBuilder(s).reverse().toString();
        // longest predfix palindrome length of s
        int len = prefixPalindrome(tmp);

        return new StringBuilder(s.substring(len)).reverse().toString() + s;
    }

    private int prefixPalindrome(String s)
    {
        char[] tmp = s.toCharArray();
        int[] next = new int[tmp.length];
        // build next table
        int i = 0;
        for (int j = i + 1; j < tmp.length; )
        {
            if (tmp[i] == tmp[j])
            {
                // 用的是index i!
                next[j] = i + 1;
                i++;
                j++;
            }
            else
            {
                // 一直往回找直到相同 或 i == 0了
                while (i > 0 && tmp[i] != tmp[j]) { i = next[i - 1]; }
                if (i == 0 && tmp[i] != tmp[j])
                {
                    // 这种情况直接赋值0
                    next[j] = 0;
                }
                else
                {
                    next[j] = i + 1;
                    // 这种情况i也需要移动，因为找到了一种prefix了
                    i++;
                }
                j++;
            }
        }

        return next[next.length - 1];
    }
}

