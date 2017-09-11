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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> res = new ArrayList<>();
        dfs(root, sum, new LinkedList<>(), res);
        return res;
    }

    private void dfs(TreeNode n, int sum, List<Integer> tmp, List<List<Integer>> res)
    {
        if (n == null) { return; }
        // leaf， 不能用n == null，否则会有重复list结果
        if (n.left == null && n.right == null)
        {
            if (sum - n.val == 0)
            {
                tmp.add(n.val);
                res.add(new ArrayList<>(tmp));
                tmp.remove(tmp.size() - 1);
            }
            return;
        }

        tmp.add(n.val);
        dfs(n.left, sum - n.val, tmp, res);
        dfs(n.right, sum - n.val, tmp, res);
        tmp.remove(tmp.size() - 1);

        return;
    }
}
