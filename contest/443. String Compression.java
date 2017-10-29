// easy

// 我觉得我弄复杂了，用的hashmap
// 或者可以用hashmap list，先得到每个char的map，最后在compress
class Solution {
    public int compress(char[] chars)
    {
        // no need to compress
        if (chars.length <= 1) { return chars.length; }

        // compress pointer
        int idx = 0;
        Map<Character, Integer> map = new HashMap<>();

        int i = 0;
        while (i < chars.length)
        {
            char c = chars[i++];
            if (map.containsKey(c))
            {
                map.put(c, map.get(c) + 1);
            }
            else
            {
                if (!map.isEmpty())
                {
                    // compress previous chars
                    for (Map.Entry<Character, Integer> e : map.entrySet())
                    {
                        int cnt = e.getValue();
                        if (cnt == 1) { chars[idx++] = e.getKey(); }
                        else
                        {
                            chars[idx++] = e.getKey();
                            String num = String.valueOf(cnt);
                            for (char n : num.toCharArray()) { chars[idx++] = n; }
                        }
                    }
                    // clean map
                    map.clear();
                }
                map.put(c, 1);
            }
        }
        // compress for last char
        for (Map.Entry<Character, Integer> e : map.entrySet())
        {
            int cnt = e.getValue();
            if (cnt == 1) { chars[idx++] = e.getKey(); }
            else
            {
                chars[idx++] = e.getKey();
                String num = String.valueOf(cnt);
                for (char n : num.toCharArray()) { chars[idx++] = n; }
            }
        }

        return idx >= chars.length? chars.length : idx;
    }
}
