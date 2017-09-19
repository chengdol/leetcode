// medium


class Solution {
    public void sortColors(int[] nums)
    {
        int l = 0;
        int r = nums.length - 1;

        for (int i = 0; i <= r; i++)
        {
            // 只移动r, 这样做一定将遇到的2都移到右边了，比如nums[r]本来就是2
            while (nums[i] == 2 && i <= r) { swap(nums, i, r--); }
            while (nums[i] == 0 && i >= l) { swap(nums, i, l++); }
        }
    }

    private void swap(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
