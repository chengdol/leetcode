// medium

// facebook 做过，忘了
// 可以two-pass or nooe pass
// two pass 可以用bucket sort, 刚好0,1,2就是index
// 这样省去了大量的if-else
// two-pass
private static final int MAX = 3;

public void sortColors(int[] nums) {
    int[] buckets = new int[MAX];
    for(int num : nums) buckets[num]++;
    for(int p = 0, val = 0; val < MAX; val++) {
        for(int count = 0; count < buckets[val]; count++) {
            nums[p++] = val;
        }

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

