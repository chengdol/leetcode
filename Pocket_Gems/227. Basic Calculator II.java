// medium


// 没思路
class Solution {
    public int calculate(String s)
    {
        if (s == null || s.isEmpty()) { return 0; }

        // 这个stack里面的内容是怎么变化的
        // stack的顶部是每次res需要叠加的内容,其他底部的内容若用过了就没啥用了
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;

        int num = 0;
        // init op as +
        char op = '+';
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (Character.isDigit(c))
            {
                num = num * 10 + (int)(c - '0');
            }

            // i = s.length() - 1表示结束收尾, 可能是数字，也可能是空格
            // 注意现在检查的是当前的c
            if ("+-*/".indexOf(c) >= 0 || i == s.length() - 1)
            {
                // 这里检查的是上一次的operator
                if ("*/".indexOf(op) >= 0)
                {
                    res -= stack.peek();
                }
                // 执行上一次的操作
                switch (op)
                {
                    case '+': stack.push(num); break;
                    case '-': stack.push(-num); break;
                    case '*': stack.push(stack.pop() * num); break;
                    case '/': stack.push(stack.pop() / num); break;
                }

                // update
                // 最新的运算结果，若是*/则已经将错误的运算减去了
                res += stack.peek();
                op = c;
                num = 0;
            }
        }

        return res;
    }
}
