// medium


// 非常基础的BFS
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
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) { return res; }

        Queue<TreeNode> que = new ArrayDeque<>();
        que.offer(root);

        while (!que.isEmpty())
        {
            int size = que.size();
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < size; i++)
            {
                TreeNode n = que.poll();
                curLevel.add(n.val);

                if (n.left != null) { que.offer(n.left); }
                if (n.right != null) { que.offer(n.right); }
            }
            res.add(curLevel);
        }

        return res;
    }
}
