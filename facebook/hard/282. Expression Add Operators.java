// hard

public class Solution {
    public List<String> addOperators(String num, int target)
    {
        List<String> res = new ArrayList<>();

        if (num == null || num.length() == 0) { return res; }
        helper(num, "", 0, 0, 0, target, res);
        return res;
    }

    // 有时用stringbuilder 操作复杂了，做出来后优化的时候再用
    // 注意 mult 用来handle * precedence, 要记录上一次的最后一个值
    private void helper(String num, String path, int pos, long val, long mult, int target, List<String> res)
    {
        if (pos == num.length())
        {
            if (val == target) { res.add(path); }
            return;
        }

        for (int i = pos; i < num.length(); i++)
        {
            // prefix 0, 直接break，不用继续递归了
            if (i != pos && num.charAt(pos) == '0') { break; }
            long operand = Long.parseLong(num.substring(pos, i + 1));

            // 才进入的情况
            if (pos == 0)
            {
                helper(num, path + operand, i + 1, operand, operand, target, res);
            }
            else
            {
                // 3 ways +, -, *
                helper(num, path + "+" + operand, i + 1, val + operand, operand, target, res);
                helper(num, path + "-" + operand, i + 1, val - operand, -operand, target, res);
                // 注意这里mult的下一个值是mult * operand, 若是连乘，当做一个整体
                helper(num, path + "*" + operand, i + 1, val - mult + mult * operand, mult * operand, target, res);
            }
        }
    }
}
