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
    public TreeNode trimBST(TreeNode root, int L, int R) {

        return helper(root, L, R);
    }

    private TreeNode helper(TreeNode n, int L, int R)
    {
        if (n == null) { return n; }

        // 这里直接return 就避免混入当前不合格的node
        if (n.val < L) { return helper(n.right, L, R); }
        if (n.val > R) { return helper(n.left, L, R); }

        // 这2步是trim的关键
        n.left = helper(n.left, L, R);
        n.right = helper(n.right, L, R);

        return n;
    }
}
