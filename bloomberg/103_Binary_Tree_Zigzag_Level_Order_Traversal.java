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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root)
    {
        List<List<Integer>> res = new LinkedList<>();
        
        if (root == null) { return res; }
        
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        // flag
        boolean zigzag = true;
        
        while (!que.isEmpty())
        {
            int size = que.size();
            List<Integer> cur = new LinkedList<>();
            
            for (int i = 0; i < size; i++)
            {
                TreeNode n = que.poll();
                // 只在构建每层的时候控制顺序
                if (zigzag)
                {
                    cur.add(n.val);
                }
                else
                {
                    cur.add(0, n.val);
                }    
                // 队列仍然是先左后右
                if (n.left != null) { que.add(n.left); }
                if (n.right != null) { que.add(n.right); }
            }
            
            zigzag = !zigzag;
            res.add(cur);
        }
        
        return res;
    }
}