// easy

/*
You're now a baseball game point recorder.

Given a list of strings, each string can be one of the 4 following types:

Integer (one round's score): Directly represents the number of points you get in this round.
"+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
"D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
"C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
Each round's operation is permanent and could have an impact on the round before and the round after.

You need to return the sum of the points you could get in all the rounds.
*/


class Solution {
    public int calPoints(String[] ops) 
    {
        // store valid scores
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        
        for (String item : ops)
        {
            if (item.equals("+"))
            {
                int pre = stack.pop();
                int cur = pre + stack.peek();
                // push back
                stack.push(pre);
                stack.push(cur);
                
                sum += cur;
            }
            else if (item.equals("D"))
            {
                int pre = stack.peek();
                int cur = pre * 2;
                
                stack.push(cur);
                sum += cur;
                
            }
            else if (item.equals("C"))
            {
                int pre = stack.pop();
                sum -= pre;
            }
            else
            {
                int cur = Integer.parseInt(item);
                stack.push(cur);
                
                sum += cur;
            }
        }
        
        return sum;
        
    }
}