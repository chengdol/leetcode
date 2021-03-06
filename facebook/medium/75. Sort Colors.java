// medium


// one pass
class Solution {
    public void sortColors(int[] nums)
    {
        // for 0
        int l = 0;
        // for 2
        int r = nums.length - 1;
        for (int i = 0; i <= r; i++)
        {
            if (nums[i] == 0) { swap(nums, i, l++); }
            // why here i--, because nums[r] could be 2
            else if (nums[i] == 2) { swap(nums, i--, r--); }
        }
    }

    private void swap(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

