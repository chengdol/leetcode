// medium


class Solution {
    public int maxArea(int[] height)
    {
        int lo = 0;
        int hi = height.length - 1;
        int area = 0;

        while (lo < hi)
        {
            area = Math.max(area, (hi - lo) * Math.min(height[lo], height[hi]));
            if (height[lo] < height[hi])
            {
                lo++;
            }
            else
            {
                hi--;
            }
        }

        return area;
    }
}
