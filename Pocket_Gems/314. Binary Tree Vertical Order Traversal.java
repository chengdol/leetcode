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

    class Node
    {
        TreeNode tn;
        int colNum;
        Node(TreeNode tn, int colNum)
        {
            this.tn = tn;
            this.colNum = colNum;
        }
    }


    public List<List<Integer>> verticalOrder(TreeNode root)
    {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) { return res; }

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Node> que = new ArrayDeque<>();

        // init
        que.offer(new Node(root, 0));
        int leftBy = Integer.MAX_VALUE;
        int rightBy = Integer.MIN_VALUE;

        while (!que.isEmpty())
        {
            int size = que.size();
            for (int i = 0; i < size; i++)
            {
                Node n = que.poll();
                map.computeIfAbsent(n.colNum, k->new ArrayList<>()).add(n.tn.val);

                TreeNode tn = n.tn;
                int col = n.colNum;
                if (tn.left != null) { que.offer(new Node(tn.left, col - 1)); }
                if (tn.right != null) { que.offer(new Node(tn.right, col + 1)); }

                // update boundary
                leftBy = Math.min(leftBy, col);
                rightBy = Math.max(rightBy, col);
            }
        }

        for (int i = leftBy; i <= rightBy; i++)
        {
            res.add(map.get(i));
        }

        return res;

    }
}
