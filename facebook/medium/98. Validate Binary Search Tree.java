// medium


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
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode n, Long min, Long max)
    {
        if (n == null) { return true; }
        if (n.val <= min || n.val >= max) { return false; }

        return helper(n.left, min, (long)(n.val)) && helper(n.right, (long)(n.val), max);
    }
}
