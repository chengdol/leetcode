// easy

class Solution {
    public int removeDuplicates(int[] nums) 
    {
        int i = 0;
        int j = 0;
        
        while (j < nums.length)
        {
            if (j > 0 && nums[j] == nums[j - 1])
            {
                j++;
                continue;
            }
            
            nums[i++] = nums[j++];
        }
        
        return i;
    }
}