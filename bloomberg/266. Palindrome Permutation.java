// easy

// 可以用set
class Solution {
    public boolean canPermutePalindrome(String s)
    {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray())
        {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // check
        // at most one char can have odd number
        int numOdd = 0;
        for (int n : freq.values())
        {
            if (n % 2 == 1) { numOdd++; }
        }

        return numOdd <= 1;
    }
}
