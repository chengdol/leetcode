// medium


// quick select
// or using priority queue
class Solution {
    public int findKthLargest(int[] nums, int k)
    {
        // shuffle
        shuffle(nums);

        // convert k
        k = nums.length - k;
        // quick select
        int lo = 0;
        int hi = nums.length - 1;
        // control range here
        while (lo < hi)
        {
            int t = partition(nums, lo, hi);
            if (t == k) { return nums[t]; }
            else if (t < k)
            {
                lo = t + 1;
            }
            else
            {
                hi = t - 1;
            }
        }

        // return
        return nums[k];
    }

    private void shuffle(int[] nums)
    {
        for (int i = 0; i < nums.length; i++)
        {
            int idx = i +(int)(Math.random() * (nums.length - i));
            swap(nums, i, idx);
        }
    }

    private int partition(int[] nums, int lo, int hi)
    {
        int i = lo;
        int j = hi + 1;

        // move all nums less than nums[lo] to its left
        // large than nums[lo] to its right
        while (i < j)
        {
            while (nums[++i] < nums[lo])
            {
                // range
                if (i >= hi) { break; }
            }

            while (nums[--j] >= nums[lo])
            {
                if (j <= lo) { break; }
            }
            // cross?
            if (i < j) { swap(nums, i, j); }
            else { break; }
        }
        // last swap
        swap(nums, lo, j);

        return j;
    }

    private void swap(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
