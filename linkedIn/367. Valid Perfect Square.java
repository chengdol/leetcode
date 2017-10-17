// easy

// 没见过就不会
class Solution {
    public boolean isPerfectSquare(int num) {

        long x = num;
        while (x * x > num)
        {
            x = (x + num / x) / 2;
        }
        return x * x == num;
    }
}
