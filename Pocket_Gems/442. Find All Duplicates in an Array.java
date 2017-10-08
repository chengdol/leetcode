// medium

// 将原数据当做index， 当然要减一
class Solution {
    public List<Integer> findDuplicates(int[] nums)
    {
        List<Integer> dup = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
        {
            int idx = Math.abs(nums[i]) - 1;
            // find dup
            if (nums[idx] < 0) { dup.add(idx + 1); }
            else { nums[idx] = - nums[idx]; }
        }
        // restore
        for (int i = 0; i < nums.length; i++) { nums[i] = Math.abs(nums[i]); }
        return dup;
    }
}
