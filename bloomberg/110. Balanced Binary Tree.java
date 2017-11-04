// easy


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

    private boolean isBal = true;
    public boolean isBalanced(TreeNode root)
    {
        helper(root);
        return isBal;
    }

    private int helper(TreeNode n)
    {
        // 从底部开始返回0
        if (n == null)
        {
            return 0;
        }

        int left = helper(n.left);
        int right = helper(n.right);
        // 看是否相差大于1?
        if (Math.abs(left - right) > 1) { isBal = false; }

        // 返回深度最大的子树值
        return Math.max(left, right) + 1;
    }
}
