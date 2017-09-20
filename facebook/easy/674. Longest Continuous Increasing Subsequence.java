// easy

// easy to do, straight forward
class Solution {
    public int findLengthOfLCIS(int[] nums)
    {
        if (nums == null || nums.length == 0) { return 0; }

        int maxLen = 1;
        int cnt = 1;
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] > nums[i - 1]) { cnt++; }
            else
            {
                maxLen = Math.max(maxLen, cnt);
                cnt = 1;
            }
        }
        return Math.max(cnt, maxLen);
    }
}
