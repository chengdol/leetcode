// eays


class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        // 只需遍历一次即可！
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++)
        {
            int other = target - nums[i];
            if (map.containsKey(other))
            {
                res[0] = i;
                res[1] = map.get(other);
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
