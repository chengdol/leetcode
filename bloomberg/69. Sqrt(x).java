// easy


// binary search
// 原理：r 为随机数,s为答案
// if r*r > x，则s < r
// if r*r < x,则s > r
public class Solution {
    public int mySqrt(int x) {

        if (x == 0 || x == 1) { return x; }

        int start = 1;
        int end = x;

        int ans = 0;
        while (start <= end)
        {
            int mid = start + (end - start) / 2;

            // mid * mid 太大了
            // if (mid * mid == x) 不行，用long也不行

            if (mid == x / mid) { return mid; }
            else if (mid < x /mid)
            {
                // 因为如果不能完全sqrt，可能mid + 1后，下一次
                // 的mid^2就超过x了，所以这次的mid就是答案
                start = mid + 1;
                // we need floor
                // 这里要想清楚
                ans = mid;
            }
            else
            {
                end = mid - 1;
            }
        }

        return ans;
    }
}
