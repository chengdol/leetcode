// easy

/*
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.
*/


// 没做出来
// 也不好想到

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int left = 0;
        int right = -1;
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        // 两个指针会交叉走一遍
        for (int i = 0, j = nums.length - 1; j >= 0; i++, j--)
        {
            // 保持遇到的最大值， 从左往右
            max = Math.max(max, nums[i]);
            if (max != nums[i])
            {
                // 更新右边界
                right = i;
            }
            // 保持遇到的最小值，从右往左
            min = Math.min(min, nums[j]);
            if (min != nums[j])
            {
                // 更新左边界
                left = j;
            }
            
        }
        
        // if already sorted, return 0
        return right - left + 1;
        
    }
}