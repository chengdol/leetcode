// medium

// recursion, to limit range of each node val

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
    public boolean isValidBST(TreeNode root)
    {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode p, long lo, long hi)
    {
        if (p == null) { return true; }
        if (p.val <= lo || p.val >= hi) { return false; }


        boolean left = helper(p.left, lo, p.val);
        boolean right = helper(p.right, p.val, hi);

        return left && right;
    }
}
