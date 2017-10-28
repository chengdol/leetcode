// medium


// no idea
class Solution {
    public double myPow(double x, int n)
    {
        // special cases
        if (x == 0) { return 0; }
        if (n == 0) { return 1; }


        if (n < 0)
        {
            if (n == Integer.MIN_VALUE)
            {
                n++; // change to -214...7;
                // 把少乘的那个补上
                return 1/x * myPow(1/x, -n);
            }

            x = 1/x;
            n = -n;
        }

        // divide and conquer
        return n % 2 == 0? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
