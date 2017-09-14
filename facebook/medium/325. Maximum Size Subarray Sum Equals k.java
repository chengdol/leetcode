// medium

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {

        // store prefix sum and its right edge index
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int len = 0;
        for (int i = 0; i < nums.length; i++)
        {
            prefixSum += nums[i];
            // must be the longest
            if (prefixSum == k) { len = i + 1; }
            else
            {
                len = Math.max(len, i - map.getOrDefault(prefixSum - k, i));
            }

            // no update for latest one if duplicate
            map.putIfAbsent(prefixSum, i);
        }
        return len;
    }
}
