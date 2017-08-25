// medium

// 简单的BFS可以解决，找到的时候必为最短路径，注意标记找过的DNA，不用再加入queue中
class Solution {
    public int minMutation(String start, String end, String[] bank) {

        // 标记在BFS中已经找过的DNA
        Set<String> visited = new HashSet<>();

        int minCnt = 0;
        Queue<String> que = new ArrayDeque<>();
        que.offer(start);

        while (!que.isEmpty())
        {
            int size = que.size();
            for (int i = 0; i < size; i++)
            {
                String s = que.poll();
                if (s.equals(end)) { return minCnt; }
                // add into visited set
                visited.add(s);

                for (String m : bank)
                {
                    if (!visited.contains(m) && isValidMutation(s, m))
                    {
                        que.offer(m);
                    }
                }
            }
            minCnt++;
        }
        return -1;
    }

    private boolean isValidMutation(String s, String t)
    {
        int diff = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) != t.charAt(i)) { diff++; }
        }
        return diff == 1;
    }
}
