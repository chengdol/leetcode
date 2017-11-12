// medium

/*
Given a binary tree, return all duplicate subtrees. For each kind of duplicate
subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

     1
    / \
   2   3
  /   / \
 4   2   4
    /
   4

  2
 /
4   and  4
*/
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root)
    {
        List<TreeNode> res = new ArrayList<>();
        helper(root, new HashMap<>(), res);

        return res;
    }

    private String helper(TreeNode n, Map<String, Integer> map, List<TreeNode> res)
    {
        if (n == null) { return "#"; }
        // convert tree to a node value string
        String sub = n.val + "," + helper(n.left, map, res) + "," + helper(n.right, map, res);
        // first meet
        if (map.getOrDefault(sub, 0) == 1) { res.add(n); }
        // avoid deplicates
        map.put(sub, map.getOrDefault(sub, 0) + 1);

        return sub;
    }
}
