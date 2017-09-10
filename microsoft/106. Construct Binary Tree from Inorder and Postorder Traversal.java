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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 和 105  类似，post-order root在最后一个
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
        {
            inMap.put(inorder[i], i);
        }

        return buildSubTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private TreeNode buildSubTree(int[] post, int postStart, int postEnd, int[] in, int inStart, int inEnd, Map<Integer, Integer> inMap)
    {
        if (postStart > postEnd) { return null; }

        TreeNode n = new TreeNode(post[postEnd]);
        int nIdx = inMap.get(post[postEnd]);
        int rightNum = inEnd - nIdx;

        n.left = buildSubTree(post, postStart, postEnd - rightNum - 1, in, inStart, nIdx - 1, inMap);
        n.right = buildSubTree(post, postEnd - rightNum, postEnd - 1, in, nIdx + 1, inEnd, inMap);

        return n;
    }
}
