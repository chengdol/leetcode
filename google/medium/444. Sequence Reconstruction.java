// medium

/*
Check whether the original sequence org can be uniquely reconstructed from the
sequences in seqs. The org sequence is a permutation of the integers from 1 to
n, with 1 ≤ n ≤ 104. Reconstruction means building a shortest common supersequence
of the sequences in seqs (i.e., a shortest sequence so that all sequences in
seqs are subsequences of it). Determine whether there is only one sequence that
can be reconstructed from seqs and it is the org sequence.

*/

// 思路：
// seqs用来构造一个directed graph
// org如果唯一，就是这个directed graph的toplogical sort的输出。
// 也就是说，每次只有一个node indregree 为 0，还有很多corner cases
class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs)
    {
        // node and its children
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        // indegree of each node
        Map<Integer, Integer> indegree = new HashMap<>();

        // build the directed graph
        for (List<Integer> seq : seqs)
        {
            // seq长度可以是0,1等
            if (seq.isEmpty()) { continue; }
            if (seq.size() == 1)
            {
                int e = seq.get(0);
                if (!graph.containsKey(e))
                {
                    graph.put(e, new HashSet<>());
                    indegree.put(e, 0);
                }
            }
            else
            {
                for (int i = 0; i < seq.size() - 1; i++)
                {
                    int cur = seq.get(i);
                    int next = seq.get(i + 1);

                    if (!graph.containsKey(cur))
                    {
                        graph.put(cur, new HashSet<>());
                        indegree.put(cur, 0);
                    }

                    if (!graph.containsKey(next))
                    {
                        graph.put(next, new HashSet<>());
                        indegree.put(next, 0);
                    }
                    // already exist or not
                    if (graph.get(cur).add(next))
                    {
                        indegree.put(next, indegree.get(next) + 1);
                    }
                }
            }
        }

        // toplogical sort
        Queue<Integer> que = new ArrayDeque<>();
        // find indegree = 0 node
        for (Map.Entry<Integer, Integer> item : indegree.entrySet())
        {
            if (item.getValue() == 0) { que.offer(item.getKey()); }
        }

        int idx = 0;
        while (!que.isEmpty())
        {
            int size = que.size();
            // 意味着有多个node的顺序不确定，不唯一
            if (size > 1) { return false; }

            int cur = que.poll();
            // 顺序对不上
            if (idx >= org.length || org[idx] != cur) { return false; }
            idx++;

            // next val
            for (Integer next : graph.get(cur))
            {
                // update indegree
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) { que.offer(next); }
            }
        }
        // return
        // 检查是否有cycle 是否所有node都用上了，因为这种情况：
        // [1]
        // [[1],[2,3],[3,2]]
        return idx == org.length && idx == graph.size();
    }
}
