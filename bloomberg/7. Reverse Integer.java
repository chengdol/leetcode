// easy


// math problem
class Solution {
    public int reverse(int x)
    {
        int res = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int next = res * 10 + tail;
            // check overflow
            if ((next - tail) / 10 != res) { return 0; }

            res = next;
            x /= 10;
        }

        return res;
    }
}
