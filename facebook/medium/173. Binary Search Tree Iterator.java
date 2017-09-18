// medium


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    Deque<TreeNode> stack = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        putAllLeftChildNode(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        int val = stack.peek().val;
        putAllLeftChildNode(stack.pop().right);

        return val;
    }

    private void putAllLeftChildNode(TreeNode n)
    {
        while (n != null)
        {
            stack.push(n);
            n = n.left;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
