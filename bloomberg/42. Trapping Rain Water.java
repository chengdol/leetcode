// hard

class Solution {
    public int trap(int[] height)
    {
        // 从两边向中间走
        int i = 0;
        int j = height.length - 1;

        int res = 0;
        int maxleft = 0;
        int maxright = 0;

        while (i < j)
        {
            if (height[i] < height[j])
            {
                // 这里必须有等于
                if (height[i] >= maxleft)
                {
                    maxleft = height[i];
                }
                else
                {
                    res += maxleft - height[i];
                }
                i++;
            }
            else
            {
                // 这里必须有等于
                if (height[j] >= maxright)
                {
                    maxright = height[j];
                }
                else
                {
                    res += maxright - height[j];
                }
                j--;
            }
        }

        return res;
    }
}
