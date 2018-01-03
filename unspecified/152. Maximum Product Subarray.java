// medium


/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/

// 类似于max sum subarray
class Solution {
    public int maxProduct(int[] nums) 
    {
        int ret = nums[0];
        
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            // need to swap max/min if nums[i] < 0
            if (nums[i] < 0)
            {
                int tmp = max;
                max = min;
                min = tmp;
            }
            
            // max/min that end with current value
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            
            ret = Math.max(ret, max);
           
        }
        
        return ret;
    }
}