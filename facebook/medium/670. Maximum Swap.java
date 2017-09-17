// medium

class Solution {
    public int maximumSwap(int num) {

        char[] nums = String.valueOf(num).toCharArray();

        // record 0~9 last index in nums
        int[] bucket = new int[10];
        for (int i = 0; i < nums.length; i++)
        {
            bucket[nums[i] - '0'] = i;
        }

        for (int i = 0; i < nums.length; i++)
        {
            // 遍历的数必须必nums[i]大才有意义
            for (int j = 9; j > nums[i] - '0'; j--)
            {
                // 目标数的索引必须在当前数的后面
                if (bucket[j] > i)
                {
                    swap(nums, i, bucket[j]);
                    return Integer.parseInt(String.valueOf(nums));
                }
            }
        }

        return num;
    }

    private void swap(char[] nums, int i, int j)
    {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
