// medium

/*
In this problem, a tree is an undirected graph that is connected and has no cycles.

The given input is a graph that started as a tree with N nodes
(with distinct values 1, 2, ..., N), with one additional edge added.
The added edge has two different vertices chosen from 1 to N, and was
not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of
edges is a pair [u, v] with u < v, that represents an undirected edge
connecting nodes u and v.

Return an edge that can be removed so that the resulting graph is a
tree of N nodes. If there are multiple answers, return the answer that
occurs last in the given 2D-array. The answer edge [u, v] should be
in the same format, with u < v.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given undirected graph will be like this:
  1
 / \
2 - 3

Example 2:
Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
Output: [1,4]
Explanation: The given undirected graph will be like this:
5 - 1 - 2
    |   |
    4 - 3

Note:
The size of the input 2D-array will be between 3 and 1000.
Every integer represented in the 2D-array will be between 1 and N, where N
is the size of the input array.
*/


// union find, 若发现root相同了，则说明有cycle了且这个edge是last的一个
class Solution {
    public int[] findRedundantConnection(int[][] edges)
    {
        int[] uf = new int[edges.length];
        // init
        for (int i = 0; i < uf.length; i++)
        {
            uf[i] = i;
        }

        int[] res = null;
        for (int[] edge : edges)
        {
            int pRoot = findRoot(uf, edge[0] - 1);
            int qRoot = findRoot(uf, edge[1] - 1);
            // find cycle, and this is the last edge to form the cycle
            if (pRoot == qRoot) { res = edge; break; }
            // union
            uf[pRoot] = qRoot;
        }
        return res;
    }

    private int findRoot(int[] uf, int i)
    {
        while (i != uf[i])
        {
            // path compression
            uf[i] = uf[uf[i]];
            i = uf[i];
        }
        return i;
    }
}
