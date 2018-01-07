// easy

/*
A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.


Example 1:
Input: 
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]

Note:
The boundaries of each input argument are 1 <= left <= right <= 10000.
*/

// 基本思路
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) 
    {
        List<Integer> ret = new LinkedList<>();
        
        for (int i = left; i <= right; i++)
        {
            int copy = i;
            // check digit from right to left 
            // one by one
            while (copy != 0)
            {
                int digit = copy % 10;
                // check
                if (digit == 0) { break; }
                if (i % digit != 0) { break; }
                
                copy /= 10;
            }
            
            if (copy == 0) { ret.add(i); }
        }
        
        return ret;
    }
}