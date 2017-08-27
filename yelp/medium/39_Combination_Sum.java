// medium

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        helper(0, candidates, target, new ArrayList<>(), res);

        return res;
    }

    private void helper(int s, int[] cand, int t, List<Integer> comb, List<List<Integer>> res)
    {
        if (t == 0)
        {
            res.add(new ArrayList<>(comb));
            return;
        }

        // 这里i = s 就只能朝一个方向找，避免了duplicate combinations
        for (int i = s; i < cand.length; i++)
        {
            if (t - cand[i] >= 0)
            {
                comb.add(cand[i]);
                helper(i, cand, t - cand[i], comb, res);
                // restore
                comb.remove(comb.size() - 1);
            }
        }

    }
}
