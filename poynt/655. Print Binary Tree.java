/// medium

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
    public List<List<String>> printTree(TreeNode root) {

        // 首先得到height of the tree
        int h = getHeight(root);
        if (h == 0) { return new ArrayList<>(); }

        String[][] arr = new String[h][(1 << h) - 1];
        // init, set all entries to ""
        for (String[] row : arr) { Arrays.fill(row, ""); }
        // process
        fill(arr, root, 1, 0, arr[0].length - 1);

        List<List<String>> res = new ArrayList<>();
        for (String[] row : arr)
        {
            res.add(Arrays.asList(row));
        }
        return res;
    }

    private void fill(String[][] arr, TreeNode n, int level, int l, int r)
    {
        if (n == null) { return; }

        // level 是从1开始的， 要减1
        arr[level - 1][(l + r) / 2] = String.valueOf(n.val);
        // 注意l, r是怎么update的
        // go left
        fill(arr, n.left, level + 1, l, (r + l) / 2);
        // go right
        fill(arr, n.right, level + 1, (r + l) / 2 + 1, r);
    }

    private int getHeight(TreeNode n)
    {
        if (n == null) { return 0; }
        return Math.max(1 + getHeight(n.left), 1 + getHeight(n.right));
    }
}
