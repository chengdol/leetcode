// medium


// firgure out by myself
class Solution {

    private TreeNode t = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return t;
    }

    private boolean helper(TreeNode n, TreeNode p, TreeNode q)
    {
        if (n == null) { return false; }

        boolean find = false;
        // 比较的是引用！
        if (n == p || n == q) { find = true; }

        boolean left = helper(n.left, p, q);
        boolean right = helper(n.right, p, q);

        // 已经找到了
        if (left && right || find && left || find && right) { t = n; }

        // 返回是否找到其中一个
        return find || left || right;
    }
}


// discussion method
class Solution {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       return helper(root, p, q);
    }

    private TreeNode helper(TreeNode n, TreeNode p, TreeNode q)
    {
        // 找到一个就不用往下找了，想想为什么
        if (n == null || n == p || n == q) { return n; }

        TreeNode left = helper(n.left, p, q);
        TreeNode right = helper(n.right, p, q);

        // 说明left一个都没找到
        if (left == null) { return right; }
        // left != null
        // 说明right一个都没找到
        if (right == null) { return left; }

        // 说明n就是LCA
        return n;
    }
}
