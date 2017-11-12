// medium


// 主要是根据index的奇偶来重新排列
/*
1.当index is even, num[idx] <= num[idx + 1]
2.index is odd, num[idx] >= num[idx + 1]
这两个条件是相互满足的，可以举例试一下
*/
class Solution {
    public void wiggleSort(int[] nums)
    {
        for (int i = 0; i < nums.length - 1; i++)
        {
            // even
            if (i % 2 == 0)
            {
                if (nums[i] > nums[i + 1]) { swap(nums, i, i + 1); }
            }
            // odd
            else
            {
                if (nums[i] < nums[i + 1]) { swap(nums, i, i + 1); }
            }
        }
    }

    private void swap(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
