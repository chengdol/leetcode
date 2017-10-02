// medium


// it is simple if you find the rule
public class Solution {
    public String optimalDivision(int[] nums)
    {
        // special cases
        if (nums.length == 1) { return "" + nums[0]; }
        if (nums.length == 2) { return nums[0] + "/" + nums[1]; }

        // init
        StringBuilder sb = new StringBuilder(nums[0] + "/(");
        for (int i = 1; i < nums.length; i++)
        {
            sb.append(nums[i] + "/");
        }

        return sb.substring(0, sb.length() - 1) + ")";
    }
}
