// hard

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
思路：以target为中心，将bst中的值存在2个stack中inorder, reverse-inorder traversal
再对比着取k个数即可
*/
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) 
    {
        Deque<Integer> predecessors = new ArrayDeque<>();
        Deque<Integer> successors = new ArrayDeque<>();
        
        startToTarget(root, target, predecessors);
        targetToEnd(root, target, successors);
        
        List<Integer> res = new LinkedList<>();
        while (k-- > 0)
        {
            // k的大小时有保证的，不会出界
            if (predecessors.isEmpty())
            {
                res.add(successors.pop());
            }
            else if (successors.isEmpty())
            {
                res.add(predecessors.pop());
            }
            // pick closest one
            else if (Math.abs(target - predecessors.peek()) < Math.abs(target - successors.peek()))
            {
                res.add(predecessors.pop());
            }
            else
            {
                res.add(successors.pop());
            }
        }
        
        return res;
    }
    
    private void startToTarget(TreeNode n, double t, Deque<Integer> dq)
    {
        if (n == null) { return; }
        // go left
        startToTarget(n.left, t, dq);
        if (n.val < t) { dq.push(n.val); }
        else
        {
            // stop traversal
            return;
        }
        
        // go right
        startToTarget(n.right, t, dq);
    }
    
    private void targetToEnd(TreeNode n, double t, Deque<Integer> dq)
    {
        if (n == null) { return; }
        // go right
        targetToEnd(n.right, t, dq);
        if (n.val >= t) { dq.push(n.val); }
        else
        {
            // stop traversal
            return;
        }
        // go left
        targetToEnd(n.left, t, dq);
    }
    
}