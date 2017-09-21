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

// quick selection
// shuffle the array first
class Solution {
    public int findKthLargest(int[] nums, int k)
    {
        // random shuffle array
        shuffle(nums);
        int lo = 0;
        int hi = nums.length - 1;
        // 这里转换一下
        k = nums.length - k;
        while (hi > lo)
        {
            int t = partition(nums, lo, hi);
            if (t < k) { lo = t + 1; }
            else if (t > k) { hi = t - 1; }
            else
            {
                // find it
                break;
            }
        }

        return nums[k];
    }

    // quick sort key part!
    private int partition(int[] nums, int lo, int hi)
    {
        // lo 就是基准
        int i = lo;
        // 后面用的--j
        int j = hi + 1;

        while (true)
        {
            while (nums[++i] < nums[lo])
            {
                if (i == hi) { break; }
            }
            while (nums[--j] > nums[lo])
            {
                if (j <= lo) { break; }
            }

            if (j <= i) { break; }
            swap(nums, i, j);
        }
        // 记得最后swap
        swap(nums, lo, j);
        return j;
    }

    private void shuffle(int[] nums)
    {
        // start from 0
        for (int i = 0; i < nums.length; i++)
        {
            // Math.random -> [0, 1)
            int j = i + (int)(Math.random() * (nums.length - i));
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j)
    {
        // no need to use xor swap
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
