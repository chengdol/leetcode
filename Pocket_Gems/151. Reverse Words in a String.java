// medium

// 这题要求reverse后的word只能间隔一个whitespace且两头没有white space
public class Solution {
    public String reverseWords(String s)
    {
        // 应该使用底层实现，而不是用string method!
        if (s == null || s.isEmpty()) { return ""; }
        char[] tmp = s.toCharArray();
        // reverse whole string
        reverse(tmp, 0, tmp.length - 1);

        // count word length
        int cnt = 0;
        int i = 0;
        for (; i < tmp.length; i++)
        {
            if (tmp[i] != ' ') { cnt++; }
            else if (tmp[i] == ' ' )
            {
                // reverse each word
                reverse(tmp, i - cnt, i - 1);
                cnt = 0;
            }
        }
        // last word not end with white spaces
        if (cnt != 0)
        {
            reverse(tmp, i - cnt, i - 1);
        }

        return cleanWhiteSpace(tmp);

    }

    private String cleanWhiteSpace(char[] tmp)
    {
        int i = 0;
        int j = 0;
        // flag
        boolean w = false;
        while (j < tmp.length)
        {
            if (tmp[j] != ' ') { tmp[i++] = tmp[j++]; w = true; }
            // find a word
            else if (tmp[j] == ' ' && w)
            {
                tmp[i++] = tmp[j++];
                w = false;
            }
            else
            {
                j++;
            }
        }
        // special case
        if (i != 0 && tmp[i - 1] == ' ') { return new String(tmp).substring(0, i - 1); }

        return new String(tmp).substring(0, i);
    }

    private void reverse(char[] tmp, int start, int end)
    {
        while (start < end)
        {
            swap(tmp, start++, end--);
        }
    }

    private void swap(char[] tmp, int i, int j)
    {
        char c = tmp[i];
        tmp[i] = tmp[j];
        tmp[j] = c;
    }
}
