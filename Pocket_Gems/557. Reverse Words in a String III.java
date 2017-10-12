// easy

// 我用的底层实现
class Solution {
    public String reverseWords(String s)
    {
        // can I use string method or stringbuilder?
        if (s == null || s.isEmpty()) { return ""; }

        char[] tmp = s.toCharArray();

        int cnt = 0;
        int i = 0;
        for (; i < tmp.length; i++)
        {
            if (tmp[i] != ' ') { cnt++; }
            else if (tmp[i] == ' ')
            {
                reverse(tmp, i - cnt, i - 1);
                cnt = 0;
            }
        }
        // reverse last word
        reverse(tmp, i - cnt, i - 1);
        return new String(tmp);
    }

    private void reverse(char[] tmp, int start, int end)
    {
        while (start < end)
        {
            char c = tmp[start];
            tmp[start] = tmp[end];
            tmp[end] = c;

            start++;
            end--;
        }
    }
}
