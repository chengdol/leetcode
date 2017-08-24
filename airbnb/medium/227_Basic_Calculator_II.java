// medium

class Solution {
    public int calculate(String s) {

        // no need to handle whitespace in s, or you can use replace(" ", "");

        Stack<Integer> st = new Stack<>();
        // init as + , 将第一个数压入stack中
        char op = '+';
        int result = 0;
        int num = 0;
        // operator的更新发生在遇到下一个operator的时候
        // 下面的例子中遇到*的时候实际上做的是上一次的加法，然后op才更新到*
        // e.g 3+2*6+4-8/2
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            // contain only non-negative integers
            if (Character.isDigit(c))
            {
                num = num * 10 + c - '0';
            }

            // 最后一位一定是数字，说明该得到最后结果了
            if ("+-*/".indexOf(c) >= 0 || i == s.length() - 1)
            {
                // 减去被误操作的integer
                if ("*/".indexOf(op) >= 0) { result -= st.peek(); }

                switch (op)
                {
                    case '+': st.push(num); break;
                    case '-': st.push(-num); break;
                    case '*': st.push(st.pop() * num); break;
                    case '/': st.push(st.pop() / num); break;
                }

                // update operator
                op = c;
                result += st.peek();
                num = 0;
            }
        }
        return result;
    }
}
