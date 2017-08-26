// hard

// 完全没想到思路
class Solution {
    public double findMaxAverage(int[] nums, int k) {

        double min = nums[0];
        double max = nums[0];
        // find min and max value in nums array
        for (int i = 0; i < nums.length; i++)
        {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        // binary search
        // min and max 就是这个数组所有可能长度subarray的平均值的上下界
        // 通过二分收缩，最后的值就是满足条件的最大均值(length at least k)
        while (min <= max)
        {
            double mid = min + (max - min) / 2;
            // accepted error less than 10^-5
            if (isAvgAbove(nums, k, mid)) { min = mid + 0.000_005; }
            else { max = mid - 0.000_005; }
        }

        return max;
    }

    private boolean isAvgAbove(int[] nums, int k, double mid)
    {
        double avg = 0;
        // window 前面可能不要的部分
        double headAvg = 0;
        for (int i = 0; i < k; i++) { avg += nums[i] - mid; }

        // must have at least k elements; the nums before the last k element should be kept if their sum > 0;
        // else we should remove them from the current sum (equivalent to update the start position)

        // pointer to next element
        int end = k;
        while (end < nums.length)
        {
            // 说明现在找到了长度至少为k的subarray的均值比mid大，可以返回继续加大mid了
            if (avg >= 0) { return true; }

            avg += nums[end] - mid;
            headAvg += nums[end - k] - mid;
            // 说明window前面部分不合格，应该移动start pointer
            if (headAvg < 0)
            {
                avg -= headAvg;
                headAvg = 0;
            }
            end++;
        }
        return avg >= 0;
    }
}
