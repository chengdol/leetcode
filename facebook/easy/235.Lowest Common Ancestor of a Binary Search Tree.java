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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root == null) { return null; }

        // find it
        if (Math.min(p.val, q.val) <= root.val && Math.max(p.val, q.val) >= root.val)
        {
            return root;
        }

        // go left
        if (Math.min(p.val, q.val) < root.val)
        {
            return helper(root.left, p, q);
        }

        return helper(root.right, p, q);
    }
}
