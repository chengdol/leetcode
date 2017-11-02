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
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root)
    {
        StringBuilder res = new StringBuilder();
        // pre order serialize
        preOrderSerialize(root, res);
        return res.substring(0, res.length() - 1);
    }

    private void preOrderSerialize(TreeNode n, StringBuilder res)
    {
        if (n == null) { res.append("null").append(','); return; }

        res.append(n.val).append(',');
        // go left
        preOrderSerialize(n.left, res);
        // go right
        preOrderSerialize(n.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data)
    {
        if (data == null || data.isEmpty()) { return null; }

        return deSerialize(data.split(","));
    }

    private TreeNode deSerialize(String[] vals)
    {
        if (vals[idx].equals("null")) { return null; }

        int val = Integer.valueOf(vals[idx]);
        TreeNode n = new TreeNode(val);
        // go left
        idx++;
        n.left = deSerialize(vals);
        // go right
        idx++;
        n.right = deSerialize(vals);

        return n;
    }

    private int idx = 0;
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
