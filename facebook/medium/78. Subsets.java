// medium

class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), res);

        return res;
    }

    private void helper(int[] nums, int pos, List<Integer> cur, List<List<Integer>> res)
    {
        res.add(new ArrayList<>(cur));

        for (int i = pos; i < nums.length; i++)
        {
            // avoid duplicates
            cur.add(nums[i]);
            helper(nums, i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
