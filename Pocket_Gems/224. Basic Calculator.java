// hard

class Solution {
    public int calculate(String s)
    {
        Deque<Integer> stack = new LinkedList<>();

        int res = 0;
        int num = 0;
        // 这个sign 其实是当前数的符号
        int sign = 1;

        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (Character.isDigit(c))
            {
                num = 10 * num + (int)(c - '0');
            }
            else if (c == '+')
            {
                res += num * sign;
                // update
                num = 0;
                sign = 1;
            }
            else if (c == '-')
            {
                res += num * sign;
                // update
                num = 0;
                sign = -1;
            }
            else if (c == '(')
            {
                stack.push(res);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                res = 0;
                sign = 1;
            }
            else if (c == ')')
            {
                res += num * sign;
                // pop sign
                res *= stack.pop();
                // add together
                res = stack.pop() + res;
                // reset
                sign = 1;
                num = 0;
            }
        }
        // 若最后一个字符是数字，要再加一下
        if (num != 0) { res += num * sign; }

        return res;
    }
}
