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
    public List<String> binaryTreePaths(TreeNode root)
    {
        List<String> res = new ArrayList<>();
        dfs(root, new StringBuilder(), res);
        return res;

    }

    private void dfs(TreeNode n, StringBuilder sb, List<String> res)
    {
        if (n == null) { return; }

        int len = sb.length();
        sb.append("->").append(n.val);

        if (n.left == null && n.right == null)
        {
            // substring return a new string!
            res.add(sb.substring(2));
            // 这里不需要return, 后面已经handle了
        }

        dfs(n.left, sb, res);
        dfs(n.right, sb, res);
        // restore sb
        sb.setLength(len);
    }
}
