// easy

// DFS
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private int diam = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        dfs(root);
        return diam;
    }

    private int dfs(TreeNode n)
    {
        if (n == null) { return 0; }

        int left = dfs(n.left);
        int right = dfs(n.right);
        // 取最大path number
        diam = Math.max(diam, left + right);
        // return 左右中最大path number + 1
        return Math.max(left, right) + 1;
    }


}
