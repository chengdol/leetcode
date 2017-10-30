// medium

// set + two pointers
public int lengthOfLongestSubstring(String s) 
{
    if (s == null || s.isEmpty()) { return 0; }
    
    Set<Character> set = new HashSet<>();
    
    int len = 0;
    int l = 0;
    int r = 0;
    while (r < s.length())
    {
        char c = s.charAt(r);
        if (!set.contains(c))
        {
            set.add(c);
        }
        else
        {
            while (l < r && s.charAt(l) != c)
            {
                set.remove(s.charAt(l));
                l++;
            }
            l++;
        }
        len = Math.max(len, set.size());
        r++;
    }
    
    return len;
}
// discussion
class Solution {
    
    public int lengthOfLongestSubstring(String s) 
    {    
        if (s.length()==0) return 0;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        int len=0;
        for (int i = 0, j = 0; i < s.length(); ++i)
        {
            char c = s.charAt(i);
            if (map.containsKey(c))
            {
                // 必须用max，因为可能s.charAt(i)的位置在j前面
                // 这里map只是更新key-value，并没删除key
                
                // 若j > map.get(c) + 1说明已经将c排除了
                j = Math.max(j, map.get(c) + 1);
            }

            // record current char position
            map.put(c, i);
            len = Math.max(len, i - j + 1);
        }
        
        return len;
    }
}
  