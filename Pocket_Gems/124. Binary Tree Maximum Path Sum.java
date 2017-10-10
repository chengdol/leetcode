// hard



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
    private int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root)
    {
        helper(root);
        return maxPathSum;
    }

    private int helper(TreeNode n)
    {
        if (n == null) { return 0; }

        int left = helper(n.left);
        int right = helper(n.right);

        // 会向上传递的最大path value
        int path1 = Math.max(n.val, n.val + Math.max(left, right));
        // 连接左右时的最大值
        int path2 = Math.max(n.val, n.val + left + right);

        maxPathSum = Math.max(maxPathSum, Math.max(path1, path2));

        return path1;
    }
}
