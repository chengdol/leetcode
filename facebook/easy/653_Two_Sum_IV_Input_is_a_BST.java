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
class Solution {
    public boolean findTarget(TreeNode root, int k) {

        if (root == null) { return false; }

        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> que = new ArrayDeque<>();
        que.offer(root);

        while (!que.isEmpty())
        {
            int size = que.size();
            for (int i = 0; i < size; i++)
            {
                TreeNode n = que.poll();
                // 这样不仅加快了得到结果，还可以避免使用自己，比如[1] k = 2, 1 还没有加入set
                // 时就知道不行
                if (set.contains(k - n.val)) { return true; }

                set.add(n.val);
                if (n.left != null) { que.offer(n.left); }
                if (n.right != null) { que.offer(n.right); }
            }
        }

        return false;
    }

}
