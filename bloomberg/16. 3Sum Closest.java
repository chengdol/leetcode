// medium

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        // assume nums.length >= 3
        Arrays.sort(nums);

        int res = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(target - res);

        // O(n2), two pointers
        for (int i = 0; i < nums.length - 2; i++)
        {
            int j = i + 1;
            int k = nums.length - 1;

            while (k > j)
            {
                int tmp = nums[i] + nums[j] + nums[k];
                if (tmp == target) { return tmp; }
                // decrease k to smaller
                else if (tmp > target) { k--; }
                // increase j to larger
                else { j++; }

                // update
                if (Math.abs(target - tmp) < diff)
                {
                    diff = Math.abs(target - tmp);
                    res = tmp;
                }
            }
        }

        return res;
    }
}
