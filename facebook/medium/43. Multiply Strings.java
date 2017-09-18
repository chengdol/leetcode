// medium



// 没找到规律
class Solution {
    public String multiply(String num1, String num2) {

        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) { return ""; }

        int[] res = new int[num1.length() + num2.length()];

        // 长度顺序不所谓
        for (int i = num1.length() - 1; i>= 0; i--)
        {
            for (int j = num2.length() - 1; j >= 0; j--)
            {
                int mult = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                // 知道这个index关系是关键
                int p1 = i + j;
                int p2 = i + j + 1;

                // 这里没用res[p1]，因为p1就是下次的p2
                int sum = res[p2] + mult;

                // 为什么这个p2 不是 += 呢？
                // 因为从右到左计算的，p2 会被更新,p1处积累的溢出会最终落到head位置，head处p1不会再溢出了
                // 99 * 99 = 9801 不会超过4位数长度
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int n : res)
        {
            // avoid leading 0
            if (n == 0 && sb.length() == 0) { continue; }

            sb.append(n);
        }

        return sb.length() == 0? "0" : sb.toString();
    }
}
