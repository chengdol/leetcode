// medium


// 完全没思路
// tree structure
class Solution {
    public List<Integer> lexicalOrder(int n)
    {
        List<Integer> res = new LinkedList<>();

        // 9个tree, root为1 ~ 9
        for (int i = 1; i < 10 && i <= n; i++)
        {
            helper(i, n, res);
        }

        return res;
    }

    private void helper(int cur, int n, List<Integer> res)
    {
        res.add(cur);

        // 每层最多只有9个
        for (int i = cur * 10; i <= n && i < (cur * 10 + 10); i++)
        {
            helper(i, n, res);
        }
    }
}
