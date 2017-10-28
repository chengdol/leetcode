// medium

// using constant space
// using dummyhead for child level
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root)
    {
        // dummyhead用来作为child那一层的head
        TreeLinkNode dummyHead = new TreeLinkNode(0);
        while (root != null)
        {
            // reuse dummyHead
            dummyHead.next = null;
            TreeLinkNode cur = dummyHead;
            // 开始处理root的child
            while (root != null)
            {
                if (root.left != null)
                {
                    cur.next = root.left;
                    cur = cur.next;
                }
                // 连接左右，如果存在的话
                if (root.right != null)
                {
                    cur.next = root.right;
                    cur = cur.next;
                }
                // 继续这一层，将root移动到左边一个
                root = root.next;
            }

            // 进入下一层
            root = dummyHead.next;
        }
    }
}
