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

    class Node
    {
        TreeNode n;
        int col;

        Node(TreeNode n, int col)
        {
            this.n = n;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root)
    {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) { return res; }

        int leftEdge = Integer.MAX_VALUE;
        int rightEdge = Integer.MIN_VALUE;

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Node> que = new ArrayDeque<>();
        que.offer(new Node(root, 0));

        while (!que.isEmpty())
        {
            Node node = que.poll();
            map.computeIfAbsent(node.col, k->new ArrayList<>()).add(node.n.val);

            // next level
            if (node.n.left != null) { que.offer(new Node(node.n.left, node.col - 1)); }
            if (node.n.right != null) { que.offer(new Node(node.n.right, node.col + 1)); }

            // update edges
            leftEdge = Math.min(leftEdge, node.col);
            rightEdge = Math.max(rightEdge, node.col);
        }

        for (int i = leftEdge; i <= rightEdge; i++)
        {
            res.add(map.get(i));
        }
        return res;
    }
}
