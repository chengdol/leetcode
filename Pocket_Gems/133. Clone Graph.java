// medium

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

// 第三次做用的dfs,注意读题label是unique的，不unique也行，用old node的reference
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) 
    {
        return dfsBuild(node, new HashMap<>());       
    }
    
    private UndirectedGraphNode dfsBuild(UndirectedGraphNode n, Map<Integer, UndirectedGraphNode> map)
    {
        if (n == null) { return null; }
        
        // create new node
        UndirectedGraphNode ncpy = new UndirectedGraphNode(n.label);
        map.put(ncpy.label, ncpy);
        
        for (UndirectedGraphNode neighbor : n.neighbors)
        {
            // 已经见过了，不用再去explore了
            if (map.containsKey(neighbor.label))
            {
                ncpy.neighbors.add(map.get(neighbor.label));
                continue;
            }
            
            ncpy.neighbors.add(dfsBuild(neighbor, map));
        }

        
        return ncpy;
    }
}