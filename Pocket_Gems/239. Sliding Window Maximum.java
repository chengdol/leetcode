// hard


// 每个元素只进入和出去一个，所以是O(n)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k)
    {
        if (nums == null || nums.length == 0 || k < 1) { return new int[0]; }

        int[] res = new int[nums.length - k + 1];
        int idx = 0;

        // 用Deque去存index, 且需要两边poll
        Deque<Integer> dq = new ArrayDeque<>();
        // 一直都是往前走，每次走一步
        for (int i = 0; i < nums.length; i++)
        {
            // 去掉不在范围类的数
            if (!dq.isEmpty() && dq.peekFirst() < i - k + 1)
            {
                dq.pollFirst();
            }

            // 从i开始，往前去掉比nums[i]小的数，保证dq中的第一个是最大的
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
            {
                dq.pollLast();
            }

            // 加入nums[i]
            dq.offerLast(i);

            // 满足初始条件，最开始要到k这么长
            // dq的第一个元素总是sliding window的最大值
            if (i >= k - 1)
            {
                res[idx++] = nums[dq.peek()];
            }
        }

        return res;
    }
}
