// medium

// 若不知道计算某一位bit之间的距离，也不会想出这个办法
class Solution {
    public int totalHammingDistance(int[] nums)
    {
        int totalDist= 0;

        int mask = 1;
        // sign bit also include
        for (int i = 0; i < 32; i++)
        {
            int curBitSetNum = 0;
            // 每次计算当前bit，所有之间的曼哈顿距离
            for (int j = 0; j < nums.length; j++)
            {
                // 得到当前bit为1的num的个数
                if ((nums[j] & mask ) != 0) { curBitSetNum++; }
            }
            totalDist += curBitSetNum * (nums.length - curBitSetNum);
            mask <<= 1;
        }

        return totalDist;
    }


}
