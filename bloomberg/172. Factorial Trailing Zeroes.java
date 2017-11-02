// easy

public class Solution {
    public int trailingZeroes(int n)
    {
        int numOf5 = 0;
        for (long i = 5; (n / i) >= 1; i *= 5)
        {
            // 每次都在增加i的值
            // 意思是每次计算一个层次的5的个数
            // 由于这里n没变化，所以就增加i就行了
            numOf5 += n / i;
        }

        return numOf5;
    }
}
