// easy

class Solution {
    public int missingNumber(int[] nums)
    {
        int sum = 0;
        for (int n : nums) { sum += n; }

        // 高斯公式 - array sum
        return (0 + nums.length) * (nums.length + 1) / 2 - sum;
    }
}
