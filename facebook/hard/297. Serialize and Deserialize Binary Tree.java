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

    char separator = ',';
    String NULL = "null";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        encodeBST2String(root, sb);
        System.out.println(sb.substring(1));
        return sb.substring(1);
    }

    // pre-order encode
    private void encodeBST2String(TreeNode n, StringBuilder sb)
    {
        if (n == null)
        {
            sb.append(separator).append(NULL);
            return;
        }

        sb.append(separator).append(n.val);
        // go left
        encodeBST2String(n.left, sb);
        // go right
        encodeBST2String(n.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] items = data.split(",");
        return decodeBSTString(items, new int[]{0});
    }

    private TreeNode decodeBSTString(String[] items, int[] pos)
    {
        // last item in Strinr must be NULL
        if (items[pos[0]].equals(NULL)) { return null; }

        TreeNode n = new TreeNode(Integer.parseInt(items[pos[0]]));
        // left
        pos[0]++;
        n.left = decodeBSTString(items, pos);
        // right
        pos[0]++;
        n.right = decodeBSTString(items, pos);

        return n;
    }
}
