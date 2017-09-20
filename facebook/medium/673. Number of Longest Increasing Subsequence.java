// medium

// 不好理解 DP
class Solution {
    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;
        // len[i] 表示到nums[i]为止，最长的递增序列长度
        int[] len = new int[n];
        // cnt[i] 表示到nums[i]为止，最长递增序列的个数
        int[] cnt = new int[n];

        // 至少也是1
        int maxLen = 1;
        for (int i = 0; i < n; i++)
        {
            // 至少也是1
            len[i] = cnt[i] = 1;
            for (int j = 0; j < i; j++)
            {
                // 说明递增的序列个数可以增加
                if (nums[i] > nums[j])
                {
                    // update
                    if (len[i] < len[j] + 1)
                    {
                        len[i] = len[j] + 1;
                        // 保持不变
                        cnt[i] = cnt[j];
                        // 记录最大长度值
                        maxLen = Math.max(maxLen, len[i]);
                    }
                    else if (len[i] == len[j] + 1)
                    {
                        cnt[i] += cnt[j];
                    }
                }
            }
        }

        //
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            if (len[i] == maxLen) { sum += cnt[i]; }
        }
        return sum;
    }
}
