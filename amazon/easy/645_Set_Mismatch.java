// easy

// 这种思路遇到过
class Solution {
    public int[] findErrorNums(int[] nums) {

        int[] res = new int[2];

        for(int i = 0; i < nums.length; i++)
        {
            // 数据时1 ~ n， index是0 ~ n-1
            int idx = Math.abs(nums[i]) - 1;
            // 把value变为负值
            if (nums[idx] > 0) { nums[idx] = -nums[idx]; }
            // find duplicate
            else { res[0] = idx + 1; }
        }

        // restore input array
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] < 0) { nums[i] = -nums[i]; }
            // postitive mean no meet this cell before
            // we can get the number from the index
            else { res[1] = i + 1; }
        }
        return res;
    }
}
