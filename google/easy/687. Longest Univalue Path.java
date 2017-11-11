// easy


/*
Given a binary tree, find the length of the longest path where each node in the
 path has the same value. This path may or may not pass through the root.

Note: The length of path between two nodes is represented by the number of edges
 between them.
*/
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
    private int res = 0;

    public int longestUnivaluePath(TreeNode root)
    {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode n)
    {
        if (n == null) { return 0; }

        int left = dfs(n.left);
        int right = dfs(n.right);

        // 记录当前node参与的path长度
        int len = 0;
        // 记录左右两边包含当前node的path最大长度
        int oneSideLen = 0;

        if (left != 0 && n.left.val == n.val)
        {
            len += left;
            oneSideLen = Math.max(oneSideLen, left);
        }
        if (right != 0 && n.right.val == n.val)
        {
            len += right;
            oneSideLen = Math.max(oneSideLen, right);
        }
        // 说明当前node不在path中
        if (len == 0) { return 1; }
        res = Math.max(res, len);

        return oneSideLen + 1;
    }
}
