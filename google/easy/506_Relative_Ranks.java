// easy


class Solution {
    public String[] findRelativeRanks(int[] nums) {

        String[] res = new String[nums.length];

        // this array used to keep index of nums
        Integer[] idx = new Integer[nums.length];
        // init
        for (int i = 0; i < idx.length; i++) { idx[i] = i; }

        // genius part
        // 因为idx记录的是nums中对应元素的index，用nums对idx进行排序
        // 得到的结果就是从大到小排序后,nums原来的位置
        // 使用comparator，这里idx必须是Integer type instead of int
        Arrays.sort(idx, (a, b) -> nums[b] - nums[a]);

        for (int i = 0; i < idx.length; i++)
        {
            if (i == 0) { res[idx[i]] = "Gold Medal"; }
            else if (i == 1) { res[idx[i]] = "Silver Medal"; }
            else if (i == 2) { res[idx[i]] = "Bronze Medal"; }
            else { res[idx[i]] = "" + (1 + i); }
        }
         return res;
    }
}
