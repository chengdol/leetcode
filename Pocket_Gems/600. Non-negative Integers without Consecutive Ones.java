// hard


// 这题没明白
class Solution {
    public int findIntegers(int num)
    {
        // 不明白为什么要reverse
        String bn = new StringBuilder(Integer.toBinaryString(num)).reverse().toString();

        int len = bn.length();
        // # of no consecutive 1 and ending with 0
        int[] a = new int[len + 1];
        // # of no consecutive 1 and ending with 1
        int[] b = new int[len + 1];
        // init
        // e.g: "0" and "1"
        a[1] = b[1] = 1;
        for (int i = 2; i <= len; i++)
        {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }

        int total = a[len] + b[len];
        // exclude number larger or equal to num
        // 没明白
        for (int i = len - 2; i >= 0; i--)
        {
            if (bn.charAt(i) == '1' && bn.charAt(i + 1) == '1') { break; }
            if (bn.charAt(i) == '0' && bn.charAt(i + 1) == '0') { total -= b[i + 1]; }
        }


        return total;
    }
}
