// hard


//
class Solution {
    public int firstMissingPositive(int[] nums)
    {
        // O(n) 因为每个数只会被access once，若在正确的位置，直接就下一个了
        for (int i = 0; i < nums.length; i++)
        {
            // 这里必须是while, e.g [3,4,-1,1]这种情况
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i])
            {
                swap(nums, i, nums[i] - 1);
            }

        }

        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] != i + 1) { return i + 1; }
        }

        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
