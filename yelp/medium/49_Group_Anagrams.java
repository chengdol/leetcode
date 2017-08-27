// medium

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs)
        {
            String tmp = sortWord(word);
            // computeIfAbsent在这里对于初始化很方便，特别是对value is collection type
            // 当key 不存在的时候, lambda expression才会执行
            // 总是返回对应的value
            map.computeIfAbsent(tmp, k -> new ArrayList<>()).add(word);

            // 当然这里可以用最基本的方法做
        }

        // 这里搞复杂了, map.values() return collection of values!

        // List<List<String>> res = new ArrayList<>();
        // for (List<String> val : map.values())
        // {
        //     res.add(val);
        // }

        // one line
        return new ArrayList<List<String>>(map.values());
    }

    // sort the word in alphabetic order
    private String sortWord(String word)
    {
        char[] arr = word.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
