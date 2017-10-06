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

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        return helper(root, p);
    }

    private TreeNode helper(TreeNode n, TreeNode t)
    {
        if (n == null) { return null; }

        // 若t.val >= n.val 则successor一定在右边
        // 如果右边没有node，则返回null
        // 如果右边有node，则还会去找这个node的左子树中最小的一个node
        // 其实找到t这个node之后，都是走的右边
        if (n.val <= t.val) { return helper(n.right, t); }

        // 比t.val大时，总是走左边
        TreeNode left = helper(n.left, t);
        return left == null? n : left;
    }
}

// find predecessor
class Solution {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        return helper(root, p);
    }

    private TreeNode helper(TreeNode n, TreeNode t)
    {
        if (n == null) { return null; }

        // 若t.val <= n.val predecessor在左边
        if (n.val >= t.val) { return helper(n.left, t); }

        // 比t.val小时，总是走左边
        TreeNode right = helper(n.right, t);
        return right == null? n : right;
    }
}
