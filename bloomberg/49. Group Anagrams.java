// medium

class Solution {
    public List<List<String>> groupAnagrams(String[] strs)
    {
        Map<String, List<String>> map = new HashMap<>();

        for (String w : strs)
        {
            // sort each word
            char[] wc = w.toCharArray();
            Arrays.sort(wc);
            String ws = new String(wc);

            map.computeIfAbsent(ws, k -> new ArrayList<>()).add(w);
        }

        return new LinkedList<>(map.values());
    }
}
