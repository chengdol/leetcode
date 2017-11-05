// medium

class Solution {
    public List<List<String>> partition(String s)
    {
        List<List<String>> res = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), res);

        return res;
    }

    private void helper(String s, int start, List<String> path, List<List<String>> res)
    {
        if (start == s.length())
        {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++)
        {
            // substring
            String tmp = s.substring(start, i + 1);
            // check
            if (isP(tmp))
            {
                path.add(tmp);
                helper(s, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isP(String s)
    {
        int i = 0;
        int j = s.length() - 1;
        while (i < j)
        {
            if (s.charAt(i) != s.charAt(j)) { return false; }
            i++;
            j--;
        }
        return true;
    }
}
