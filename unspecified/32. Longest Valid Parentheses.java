// hard


/*
Given a string containing just the characters '(' and ')', find the length 
of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()"
, which has length = 4.
*/

// 没想到思路

class Solution {
    public int longestValidParentheses(String s) 
    {
        // stack used to store index of left parenthesis
        Deque<Integer> stack = new LinkedList<>();
        
        int len = 0;
        // store left boundary of valid parentheses
        int left = -1;
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c == '(')
            {
                // push the index of left parenthesis
                stack.push(i);
            }
            else
            {
                // update left
                if (stack.isEmpty()) { left = i; }
                else
                {
                    // pop one left parenthesis
                    stack.pop();
                    if (stack.isEmpty())
                    {
                        len = Math.max(len, i - left);
                    }
                    else
                    {
                        len = Math.max(len, i - stack.peek());
                    }
                }
            }
        }
        
        
        return len;
    }
}