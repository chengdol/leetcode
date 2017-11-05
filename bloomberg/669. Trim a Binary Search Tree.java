// easy



class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R)
    {
        return helper(root, L, R);
    }

    private TreeNode helper(TreeNode n, int L, int R)
    {
        if (n == null) { return null; }
        // ouside the range
        if (n.val < L) { return helper(n.right, L, R); }
        if (n.val > R) { return helper(n.left, L, R); }

        // inside the range
        n.left = helper(n.left, L, R);
        n.right = helper(n.right, L, R);

        return n;
    }
}
