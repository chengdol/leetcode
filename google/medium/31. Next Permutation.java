// medium


/*
Implement next permutation, which rearranges numbers into the lexicographically
next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible
order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding
outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

和之前有道题类似，那道题貌似是交换一组数字，得到下一个比它大的数
这里是得到字典顺序的下一个大的数，多了一个排序(reverse)

*/

class Solution {
    public void nextPermutation(int[] nums)
    {
        if (nums == null || nums.length == 0) { return; }
        // from right to left
        // find nums[i] which nums[i] < nums[i + 1]
        int i = nums.length - 2;
        while (i >= 0)
        {
            if (nums[i] < nums[i + 1]) { break; }
            i--;
        }
        // impossible
        if (i < 0) { reverse(nums, 0, nums.length - 1); return; }

        // from right to left
        // find the first one larger than nums[i]
        // swap them
        int j = nums.length - 1;
        while (j > i)
        {
            if (nums[j] > nums[i]) { swap(nums, i, j); break; }
            j--;
        }
        // reverse right side of nums
        // 因为之前已经是降序排列的
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int i, int j)
    {
        while (i < j) { swap(nums, i++, j--); }
    }
}
