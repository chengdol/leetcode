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
    private int cnt = 0;
    private int res = 0;

    public int kthSmallest(TreeNode root, int k)
    {
        helper(root, k);
        return res;
    }

    private void helper(TreeNode n, int k)
    {
        // 先走左边，直到最小值
        if (n.left != null) { helper(n.left, k); }

        cnt++;
        if (cnt == k)
        {
            res = n.val;
            return;
        }

        // 再走右边
        if (n.right != null) { helper(n.right, k); }
    }
}
