// medium

// 3 ways:
// 1. sort then fetch
// 2. pq with k size
// 3. quick select

// pq version
class Solution {
    public int findKthLargest(int[] nums, int k) {

        Queue<Integer> pq = new PriorityQueue<>();
        for (int n : nums)
        {
            pq.offer(n);

            if (pq.size() > k)
            {
                pq.poll();
            }
        }

        return pq.peek();
    }
}

// qs
class Solution {
    // 典型的quick select
    public int findKthLargest(int[] nums, int k) {

        // shuffle the array
        shuffle(nums);
        // quick selection alg
        int t = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        // at least one element
        while (lo < hi)
        {
            int r = quickSelect(nums, lo, hi);
            if (r == t) { return nums[r]; }
            else if (r > t)
            {
                hi = r - 1;
            }
            else
            {
                lo = r + 1;
            }
        }
        // only one element
        return nums[t];
    }

    private void shuffle(int[] nums)
    {
        for (int i = 0; i < nums.length; i++)
        {
            int j = i + (int)(Math.random() * (nums.length - i));
            swap(nums, j, i);
        }
    }

    private int quickSelect(int[] nums, int lo, int hi)
    {
        if (lo >= hi) { return -1; }

        int i = lo;
        int j = hi + 1;
        while (true)
        {
            // 这里不用关系出边界，因为数组至少有2个元素了
            while (nums[++i] < nums[lo])
            {
                // 注意这里的边界条件
                if (i == hi) { break; }
            }

            while (nums[--j] > nums[lo]);
            {
                if (j == lo) { break; }
            }

            // cross就break;
            if (j <= i) { break; }
            // 否则swap
            swap(nums, i, j);
        }
        // swap lo 与 j
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
