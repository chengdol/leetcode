// medium

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/


// greedy
// 每次都找最远能到哪个位置
class Solution {
    public boolean canJump(int[] nums) 
    {
        int farest = 0;
        // i is also the distance
        for (int i = 0; i <= farest; i++)
        {
            // update farest index we can reach
            farest = Math.max(farest, i + nums[i]);
            // stop early
            if (farest >= nums.length - 1)
            {
                return true;
            }
        }
        
        return false;
    }
}