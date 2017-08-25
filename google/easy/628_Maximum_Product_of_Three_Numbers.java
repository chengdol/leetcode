//easy

class Solution {
    public int maximumProduct(int[] nums) {

        int idx = nums.length - 1;

        Arrays.sort(nums);
        return Math.max(nums[idx] * nums[idx - 1] * nums[idx - 2], nums[0] * nums[1] * nums[idx]);
    }
}
