// hard

class Solution {
    public List<String> removeInvalidParentheses(String s)
    {
        List<String> res = new ArrayList<>();
        if (s == null) { return res; }

        Queue<String> que = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        // init
        que.offer(s);
        visited.add(s);

        boolean find = false;
        while (!que.isEmpty())
        {
            int size = que.size();

            for (int i = 0; i < size; i++)
            {
                String t = que.poll();

                // find in this BFS level
                if (isValid(t))
                {
                    res.add(t);
                    find = true;
                }
                // 因为只找最少的操作，在这层找到了，就算有不合格的，也不用做下一步的分解了
                // 因为这是BFS
                if (find) { continue; }

                // 继续分解string，去掉一个括号
                for (int j = 0; j < t.length(); j++)
                {
                    // 跳过非括号的char
                    char c = t.charAt(j);
                    if ((c == '(') || (c == ')'))
                    {
                        String next = t.substring(0, j) + t.substring(j + 1);
                        if (!visited.contains(next))
                        {
                            que.offer(next);
                            visited.add(next);
                        }
                    }
                }
            }
        }

        return res;
    }


    private boolean isValid(String p)
    {
        int cnt = 0;
        for (char c : p.toCharArray())
        {
            if (c == '(') { cnt++; }
            else if (c == ')')
            {
                if (cnt == 0) { return false; }
                cnt--;
            }
        }
        return cnt == 0;
    }
}
