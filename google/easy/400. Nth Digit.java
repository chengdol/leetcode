// easy

// math problem
class Solution {
    public int findNthDigit(int n)
    {
        // 每个数字类别的长度
        // 比如1~9长度1,10~99长度2...
        int len = 1;
        // 每个数字类别的个数
        // 比如1~9共有9个，10~99共有90个..
        long cnt = 9;
        // 每个不同长度数字group的起始位置
        int base = 1;

        // 首先找目标digit所在的类别数字的长度
        while (n > len * cnt)
        {
            n -= len * cnt;
            // update
            len++;
            cnt *= 10;
            base *= 10;
        }

        // 找到目标数字
        // 不明白为什么n - 1
        int target = base + (n - 1)/ len;
        // 转成String
        String number = String.valueOf(target);
        // 取digit,注意这里char是当作integer处理得
        return Integer.valueOf(number.charAt((n - 1) % len)) - '0';
    }
}
