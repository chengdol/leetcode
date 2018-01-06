// medium

/*
Given an array of integers and an integer k, you need to find the total number
 of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2

Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer
 k is [-1e7, 1e7].
*/

 // brute force也可以 O(n^2)

class Solution {
    public int subarraySum(int[] nums, int k) 
    {
        int sum = 0;
        int ret = 0;
        
        // key is prefix sum
        // value is counter
        Map<Integer, Integer> map = new HashMap<>();
        // init
        map.put(0, 1);
        
        for (int num : nums)
        {
            sum += num;
            // 说明前面有一段subarray合格
            // 这里把k理解为2个prefix sum之间的差值
            ret += map.getOrDefault(sum - k, 0);
            // number 有可能是负数或0，造成prefix sum可能重复
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return ret;
    }
}