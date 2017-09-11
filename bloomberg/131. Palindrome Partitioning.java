// medium


class Solution {
    public List<List<String>> partition(String s)
    {
        List<List<String>> res = new ArrayList<>();
        if (s == null) { return res; }

        helper(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void helper(String str, int start, List<String> tmp, List<List<String>> res)
    {
        // 说明找齐了
        if (start >= str.length())
        {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = start + 1; i <= str.length(); i++)
        {
            // 从给定的起始位置，依次增加string长度
            String p = str.substring(start, i);
            // 只有符合要求才可能递归下一步
            if (isPalindrome(p))
            {
                tmp.add(p);
                helper(str, i, tmp, res);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s)
    {
        int i = 0, j = s.length() - 1;
        while (i < j)
        {
            if (s.charAt(i++) != s.charAt(j--)) { return false; }
        }
        return true;
    }
}
