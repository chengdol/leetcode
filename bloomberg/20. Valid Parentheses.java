// easy

// using stack
class Solution {
    public boolean isValid(String s)
    {
        if (s == null) { return true; }
        if (s.length() % 2 != 0) { return false; }

        Deque<Character> stack = new LinkedList<>();
        for (Character c : s.toCharArray())
        {
            if (c == '(' || c == '{' || c == '[') { stack.push(c); }
            else
            {
                if (stack.isEmpty()) { return false; }

                char p = stack.pop();
                switch (c)
                {
                    case ')': if (p != '(') return false; break;
                    case '}': if (p != '{') return false; break;
                    case ']': if (p != '[') return false; break;
                }
            }
        }

        return stack.isEmpty();
    }
}
