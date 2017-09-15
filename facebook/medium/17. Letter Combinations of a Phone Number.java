// medium


class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) { return res; }

        Map<Character, String> map = new HashMap<>();
        // init
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        Queue<String> que = new ArrayDeque<>();
        // init
        que.offer("");

        for (char c : digits.toCharArray())
        {
            int size = que.size();
            char[] next = map.get(c).toCharArray();
            // 当前que中的所有element都要append
            for (int i = 0; i < size; i++)
            {
                String str = que.poll();
                for (char n : next)
                {
                    que.offer(str + n);
                }
            }
        }
        res.addAll(que);

        return res;
    }
}
