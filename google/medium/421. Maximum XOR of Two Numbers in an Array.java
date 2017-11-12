// medium

/*
Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
Could you do this in O(n) runtime?

Input: [3, 10, 5, 25, 2, 8]
Output: 28
Explanation: The maximum result is 5 ^ 25 = 28.

不需要去关心顺序，两个数必然是一前一后
This algorithm's idea is:
to iteratively determine what would be each bit of the final result from left to
 right. And it narrows down the candidate group iteration by iteration. e.g.
 assume input are a,b,c,d,...z, 26 integers in total. In first iteration, if
 you found that a, d, e, h, u differs on the MSB(most significant bit), so you
 are sure your final result's MSB is set. Now in second iteration, you try to
 see if among a, d, e, h, u there are at least two numbers make the 2nd MSB differs,
 if yes, then definitely, the 2nd MSB will be set in the final result. And maybe
  at this point the candidate group shinks from a,d,e,h,u to a, e, h. Implicitly,
   every iteration, you are narrowing down the candidate group, but you don't need
   to track how the group is shrinking, you only cares about the final result.
*/

class Solution {
    public int findMaximumXOR(int[] nums)
    {
        int mask = 0;
        int max = 0;
        // integer 32 bits long
        for (int i = 31; i >= 0; i--)
        {
            // 因为找最大值，所以从左到右，扩大mask的范围
            mask |= (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums)
            {
                // 收集所有与mask相"与"的可能结果，目前只关心mask覆盖的部分
                set.add(num & mask);
            }
            // 下一个可能的最大值
            int tmp = max | (1 << i);
            for (int prefix : set)
            {
                // 这里其实用到了bit manipulate的性质
                // a ^ b = c 则a ^ c = b 则b ^ c = a
                // 其实是想表达set中的两个数相与能得到下一个最大值
                if (set.contains(tmp ^ prefix))
                {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}
