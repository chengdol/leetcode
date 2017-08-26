//easy

class Solution {
    public int maximumProduct(int[] nums) {

        int idx = nums.length - 1;
        // 也可以不用sort，用iteration + if-else去获得最大的三个数 和 最小的2个数
        Arrays.sort(nums);
        // 最大的数总是在这里产生
        return Math.max(nums[idx] * nums[idx - 1] * nums[idx - 2], nums[0] * nums[1] * nums[idx]);
    }
}
