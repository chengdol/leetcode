// medium


// esay to do with backtracking
class Solution {
    public List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> res = new LinkedList<>();
        helper(nums, 0, new LinkedList<>(), res);

        return res;
    }

    private void helper(int[] nums, int pos, List<Integer> path, List<List<Integer>> res)
    {

        res.add(new LinkedList<>(path));
        for (int i = pos; i < nums.length; i++)
        {
            path.add(nums[i]);
            // next
            helper(nums, i + 1, path, res);
            // restore path
            path.remove(path.size() - 1);
        }
    }
}
