// medium

class Solution {
    public int threeSumClosest(int[] nums, int target)
    {
        // sort array
        // 为什么这里还要sort?因为还是要和target比较，去缩小差值！
        Arrays.sort(nums);

        // init
        int res = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(res - target);

        for (int i = 0; i < nums.length - 2; i++)
        {
            int lo = i + 1;
            int hi = nums.length - 1;

            while (lo < hi)
            {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(sum - target) < diff)
                {
                    diff = Math.abs(sum - target);
                    res = sum;
                }

                // compare
                if (sum == target) { return sum; }
                else if (sum > target) { hi--; }
                else { lo++; }
            }
        }
        return res;
    }
}
