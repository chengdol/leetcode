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
    public boolean checkEqualTree(TreeNode root) {

        if (root == null) { return false; }

        // sum and it's corresponding group number that get the sum
        Map<Integer, Integer> map = new HashMap<>();
        int sum = treeSum(root, map);
        // 若总和是0， 如[0, -1, 1]必须排除这种情况，就看有多少符合的tree group，若只有一个
        // 说明不能2分
        if (sum == 0) { return map.getOrDefault(sum, 0) > 1; }
        return (sum % 2 == 0) && (map.containsKey(sum / 2));
    }

    // 我理解复杂了，根本不需要关心划分后的另一部分
    // 只要保证一半的划分方式是对的，另一半也是符合要求的
    private int treeSum(TreeNode n, Map<Integer, Integer> map)
    {
        if (n == null) { return 0; }
        int curSum = n.val + treeSum(n.left, map) + treeSum(n.right, map);
        // put into map
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        return curSum;
    }
}
