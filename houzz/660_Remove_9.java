// hard
// this is the radix problem

class Solution {
    public int newInteger(int n) {

        // convert to 9-based number
        int ans = 0;
        int base = 1;

        // 没想明白可以参考10进制到10进制的转换
        while (n > 0)
        {
            ans += (n % 9) * base;
            n /= 9;
            // 这里必须是10
            base *= 10;
        }

        return ans;
    }
}
