// medium

/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.


*/

// typical toplogical sort

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {           
        //
        Map<Integer, Set<Integer>> to = new HashMap<>();
        Map<Integer, Set<Integer>> from = new HashMap<>();
        
        for (int[] edge : prerequisites)
        {
            // no duplicate edges
            to.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
            from.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
        }
        
        Queue<Integer> que = new LinkedList<>();
        // find vertex with no incoming edge
        // add into queue
        for (int i = 0; i < numCourses; i++)
        {
            if (!from.containsKey(i))
            {
                que.add(i);
            }
        }
        
        while (!que.isEmpty())
        {
            int current = que.poll();
            Set<Integer> nextNodes = to.getOrDefault(current, new HashSet<>());
            
            // put next node with no incoming edge into queue
            for (int next : nextNodes)
            {
                Set<Integer> set = from.get(next);
                set.remove(current);
                
                if (set.isEmpty())
                {
                    que.add(next);
                }
            }
            
            to.remove(current);
        }
        
        return to.isEmpty();
    }
}