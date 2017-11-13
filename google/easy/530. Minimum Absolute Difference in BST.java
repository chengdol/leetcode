// easy

/*
Given a binary search tree with non-negative values, find the minimum absolute
difference between values of any two nodes

Note: There are at least two nodes in this BST

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2
and 1 (or between 2 and 3).
*/

// in order traversal
// 这里用到了Integer类型，方便处理null node

class Solution {
    private int minDiff = Integer.MAX_VALUE;
    private Integer pre = null;

    public int getMinimumDifference(TreeNode root)
    {
        inOrderTraversal(root);
        return minDiff;
    }

    private void inOrderTraversal(TreeNode n)
    {
        if (n == null) { return; }

        inOrderTraversal(n.left);
        if (pre != null)
        {
           minDiff = Math.min(minDiff, n.val - pre);
        }

        pre = n.val;
        inOrderTraversal(n.right);
    }
}
