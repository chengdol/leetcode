// hard


class Solution {
    public String alienOrder(String[] words) 
    {
        String result = "";
        if (words == null || words.length == 0) { return result; }
        // 记录每个char所处的层，从0开始，类似与tree
        Map<Character, Integer> level = new HashMap<>();
        // map，记录一个char和他后续的chars集合
        Map<Character, Set<Character>> map = new HashMap<>();
        // init
        for (String w : words)
        {
            for (char c : w.toCharArray())
            {
                level.putIfAbsent(c, 0);
            }
        }
        
        
        for (int i = 0; i < words.length - 1; i++)
        {
            // compare two adjacent words
            String w1 = words[i];
            String w2 = words[i + 1];
            // 为什么取最短的长度，因为超出的char无法判断优先级
            int len = Math.min(w1.length(), w2.length());
            for (int j = 0; j < len; j++)
            {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                
                // 找到了c1->c2的顺序了
                if (c1 != c2)
                {
                    Set<Character> set = map.getOrDefault(c1, new HashSet<>());
                    if (!set.contains(c2))
                    {
                        set.add(c2);
                        // 别忘了放回去
                        map.put(c1, set);
                        level.put(c2, level.get(c2) + 1);
                    }

                    break;
                }
                
            }
        }
        // find root chars
        Queue<Character> que = new ArrayDeque<>();
        for (Map.Entry<Character, Integer> item : level.entrySet())
        {
            if (item.getValue() == 0) { que.offer(item.getKey()); }
        }
        
        // 把在root char后面的char加上
        while (!que.isEmpty())
        {
            char c = que.poll();
            // append in result
            result += c;
            // 先确定这个c有没有后续
            if (map.containsKey(c))
            {
                for (char c2 : map.get(c))
                {
                    // 因为已经使用了c，则后面的char level减一
                    int val = level.get(c2) - 1;
                    // 放回去
                    level.put(c2, val);
                    if (val == 0) { que.offer(c2); }
                }                
            }

        }
        // 说明char 没用完，有问题
        if (result.length() != level.size()) { return ""; }
        return result;
        
    }
}