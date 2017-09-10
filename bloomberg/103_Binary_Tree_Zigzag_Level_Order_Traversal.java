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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) { return res; }

        boolean zigzag = true;
        Queue<TreeNode> que = new ArrayDeque<>();

        que.offer(root);
        while (!que.isEmpty())
        {
            int size = que.size();
            List<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++)
            {
                // from left to right
                TreeNode n = que.poll();
                if (zigzag == true)
                {
                    level.add(n.val);
                }
                // from right to left
                else
                {
                    level.add(0, n.val);
                }

                if (n.left != null) { que.offer(n.left); }
                if (n.right != null) { que.offer(n.right); }
            }

            if (!level.isEmpty()) { res.add(level); }
            zigzag = !zigzag;
        }
        return res;
    }
}
