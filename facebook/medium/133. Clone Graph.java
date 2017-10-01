// medium


// BFS
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {

    // label uniquely
    Map<Integer, UndirectedGraphNode> map = new HashMap<>();
    UndirectedGraphNode root = null;

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node)
    {
        if (node == null) { return node; }

        Queue<UndirectedGraphNode> que = new ArrayDeque<>();
        que.offer(node);
        root = new UndirectedGraphNode(node.label);

        map.put(node.label, root);
        while (!que.isEmpty())
        {
            UndirectedGraphNode n = que.poll();
            UndirectedGraphNode newNode = map.getOrDefault(n.label, new UndirectedGraphNode(n.label));

            for (UndirectedGraphNode child : n.neighbors)
            {
                UndirectedGraphNode newChild = map.getOrDefault(child.label, new UndirectedGraphNode(child.label));
                newNode.neighbors.add(newChild);
                // add into queue with old node if no explore before
                if (!map.containsKey(child.label)) { que.offer(child); }
                // mark new node
                map.putIfAbsent(child.label, newChild);
            }
        }

        return root;
    }
}


// 也可以用DFS










