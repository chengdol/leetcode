// medium


// forget
class Solution {
    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) { return res; }

        // sort array
        Arrays.sort(nums);
        // last two if for nums[lo] and nums[hi]
        for (int i = 0; i < nums.length - 2; i++)
        {
            // skip duplicates
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1]))
            {
                int lo = i + 1;
                int hi = nums.length - 1;
                int sum = -nums[i];

                while (lo < hi)
                {
                    // find triple
                    if (nums[lo] + nums[hi] == sum)
                    {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        // skip duplicate if we find the triple
                        while (lo < hi && nums[lo + 1] == nums[lo]) { lo++; }
                        while (lo < hi && nums[hi - 1] == nums[hi]) { hi--; }
                        lo++;
                        hi--;
                    }
                    else if (nums[lo] + nums[hi] < sum)
                    {
                        lo++;
                    }
                    else
                    {
                        hi--;
                    }
                }
            }
        }

        return res;
    }
}
