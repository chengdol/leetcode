// easy

class Solution {
    public int findRadius(int[] houses, int[] heaters)
    {
        // 要用二分，先排序
        Arrays.sort(heaters);
        int res = Integer.MIN_VALUE;

        for (int house : houses)
        {
            int idx = Arrays.binarySearch(heaters, house);
            // not find
            if (idx < 0)
            {
                // get the first index of element that larger than house
                idx = -(idx + 1);
            }

            // 找与左边最近heater的距离
            int leftDist = idx - 1 >= 0? house - heaters[idx - 1] : Integer.MAX_VALUE;
            // 与右边最近heater的距离
            int rightDist = idx >= heaters.length? Integer.MAX_VALUE : heaters[idx] - house;

            // 取两个中的最小值，最小值中的最大值
            res = Math.max(res, Math.min(leftDist, rightDist));
        }
        return res;
    }
}
