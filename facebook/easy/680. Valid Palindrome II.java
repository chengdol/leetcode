// easy


class Solution {
    public boolean validPalindrome(String s)
    {
        if (s == null || s.length() <= 1) { return true; }
        int l = 0;
        int r = s.length() - 1;
        while (l < r)
        {
            if (s.charAt(l) != s.charAt(r))
            {
                // delete one of these two characters
                // 已经检查过的不用再检测了，直接检测剩余的部分
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }
            l++;
            r--;
        }

        return true;
    }

    private boolean isPalindrome(String s, int l, int r)
    {
        while (l < r)
        {
            if (s.charAt(l++) != s.charAt(r--)) { return false; }
        }
        return true;
    }
}
