// easy

class Solution {
    public int firstUniqChar(String s)
    {
        int[] freq = new int[26];
        // count freq for each char in string s
        for (char c : s.toCharArray())
        {
            freq[c - 'a']++;
        }
        // find first char freq is 1 and return index
        int idx = 0;
        for (char c : s.toCharArray())
        {
            if (freq[c - 'a'] == 1) { return idx; }
            idx++;
        }

        return -1;
    }
}
