// medium

// 关键是如何避免重复，一个是起始数的去重，一个是two pointers部分的去重
// test cases:
// [-1, 0, 1, 2, -1, 4]
// [-2,-1,-1,-1,3,3,3,7]
// [0,0,0,0,0,0]

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) { return res; }

        // sort nums
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++)
        {
            // deduplicates
            if (i > 0 && nums[i] == nums[i - 1]) { continue; }

            // two pointers
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r)
            {
                int sum = nums[l] + nums[r];
                if (sum == -nums[i])
                {
                    // add result, using asList!
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // deduplicates
                    while (l < nums.length - 1 && nums[l] == nums[l + 1]) { l++; }
                    l++;
                    while (r > l && nums[r - 1] == nums[r]) { r--; }
                    r--;
                }
                else if (sum > -nums[i]) { r--; }
                else if (sum < -nums[i]) { l++; }
            }
        }
        return res;
    }
}
