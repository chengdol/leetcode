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

// solve it recursive or iterative
class Solution {
    public boolean isSymmetric(TreeNode root)
    {
        // null root?
        if (root == null) { return true; }
        // only root
        if (root.left == null && root.right == null) { return true; }
        // only has one child
        if (root.left == null || root.right == null) { return false; }

        // use two queue to do symmetric comparsion
        Queue<TreeNode> leftQue = new ArrayDeque<>();
        Queue<TreeNode> rightQue = new ArrayDeque<>();
        // init
        leftQue.add(root.left);
        rightQue.add(root.right);

        while (!leftQue.isEmpty() && !rightQue.isEmpty())
        {
            TreeNode leftNode = leftQue.poll();
            TreeNode rightNode = rightQue.poll();

            if (leftNode.val != rightNode.val) { return false; }

            // next level
            if (leftNode.left != null) { leftQue.add(leftNode.left); }
            if (rightNode.right != null) { rightQue.add(rightNode.right); }
            // check queue size
            if (leftQue.size() != rightQue.size()) { return false; }

            if (leftNode.right != null) { leftQue.add(leftNode.right); }
            if (rightNode.left != null) { rightQue.add(rightNode.left); }
            // check queue size
            if (leftQue.size() != rightQue.size()) { return false; }
        }

        return true;
    }
}


// recursion
//============================================================================
class Solution {
    public boolean isSymmetric(TreeNode root)
    {
        if (root == null) { return true; }
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode p, TreeNode q)
    {
        if (p == null && q == null) { return true; }
        if (p == null || q == null) { return false; }

        return (p.val == q.val) && helper(p.left, q.right) && helper(p.right, q.left);
    }
}


















