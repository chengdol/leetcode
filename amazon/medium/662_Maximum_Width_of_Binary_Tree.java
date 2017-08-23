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

    // wrap the treeNode with idx
    // so we can compute the distance between two node
    class Node
    {
        TreeNode n;
        // idx of current treenode
        int idx;

        Node(TreeNode n, int idx)
        {
            this.n = n;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null) { return 0; }

        Queue<Node> que = new ArrayDeque<>();
        // root idx is 1
        que.offer(new Node(root, 1));

        int maxWidth = 0;
        while (!que.isEmpty())
        {
            // compute max width for each level, keep the max one
            int leftBoundary = Integer.MAX_VALUE;
            int rightBoundary = Integer.MIN_VALUE;

            int size = que.size();
            for (int i = 0; i < size; i++)
            {
                Node n = que.poll();
                // update left and right boundary
                leftBoundary = Math.min(leftBoundary, n.idx);
                rightBoundary = Math.max(rightBoundary, n.idx);

                // children
                if (n.n.left != null) { que.offer(new Node(n.n.left, n.idx * 2)); }
                if (n.n.right != null) { que.offer(new Node(n.n.right, n.idx * 2 + 1)); }
            }

            maxWidth = Math.max(maxWidth, rightBoundary - leftBoundary + 1);
        }

        return maxWidth;

    }
}
