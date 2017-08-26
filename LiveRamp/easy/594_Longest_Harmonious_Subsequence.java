// easy

// 当时没做出来。。
class Solution {
    public int findLHS(int[] nums) {

        if (nums == null) { return 0; }
        // key is start of subsquence, value is length
        Map<Integer, Integer> map = new HashMap<>();

        // count for each number
        for (int n : nums)
        {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // form subsequence
        // only need to care k + 1 or k - 1
        int maxLen = 0;
        for (int k : map.keySet())
        {
            // 只能相差1，所以subseqence中就2种数
            if (map.containsKey(k + 1))
            {
                maxLen = Math.max(maxLen, map.get(k) + map.get(k + 1));
            }
        }

        return maxLen;
    }
}
