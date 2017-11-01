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


// 还要会post in order 去构造tree
// link:
// https://goo.gl/bpAibk
// construt by in and post order


class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        Map<Integer, Integer> inMap = new HashMap<>();
        // init
        for (int i = 0; i < inorder.length; i++)
        {
            inMap.put(inorder[i], i);
        }

        return buildSubTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private TreeNode buildSubTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd, Map<Integer, Integer> inMap)
    {
        // 说明该node不存在，只能为null
        // 这个结束条件不好想
        if (preStart > preEnd) { return null; }

        // 主要依靠pre-order中的内容建造tree, in-order只用来提供左右子树node数量
        TreeNode n = new TreeNode(pre[preStart]);
        int nIdx = inMap.get(pre[preStart]);
        int leftNum = nIdx - inStart;

        // 限定了子树内容在pre in order中的范围
        n.left = buildSubTree(pre, preStart + 1, preStart + leftNum, in, inStart, nIdx - 1, inMap);
        n.right = buildSubTree(pre, preStart + leftNum + 1, preEnd, in, nIdx + 1, inEnd, inMap);

        return n;
    }
}
