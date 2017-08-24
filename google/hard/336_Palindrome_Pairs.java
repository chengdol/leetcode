// hard
// TLE了。我用的最直观的办法，两两首尾互相连接，测试是否palindrome.O(m^2*n) m是数组长度, n是平均word长度，这种情况下，若有很多word，就不好。

// discussion中的方法很特别，先将所有word和其idx加入map中，对每一个word，把它分成2半，比如w1,w2；先看w2是否是palindrome，若是，去map里查查有没有w1.reverse.若有，比如w1r,则最后组成的w1+w2+w1r就是一个palindrome了，再看w1是否是palindrome，去map查看w2.reverse是否存在，同理。。
// 这个方法O(m*n^2)

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> res = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        // init
        for (int i = 0; i < words.length; i++) { map.put(words[i], i); }

        // for each word
        for (int i = 0; i < words.length; i++)
        {
            // partition into 2 parts
            // 这里 <= 而不是 < 谁能为测试例子中有 "" 的情况
            for (int j = 0; j <= words[i].length(); j++)
            {
                String w1 = words[i].substring(0, j);
                String w2 = words[i].substring(j);

                // 分别从2个方向上查看
                if (isPalindrome(w2))
                {
                    String w1r = new StringBuilder(w1).reverse().toString();
                    int idx = i;
                    // ！= i, 防止自己和自己重复，比如2个"s" ---> "ss"，这样不行
                    if ((idx = map.getOrDefault(w1r, i)) != i)
                    {
                        res.add(Arrays.asList(i, idx));
                    }
                }

                // deduplicate
                if (isPalindrome(w1) && !w1.isEmpty())
                {
                    String w2r = new StringBuilder(w2).reverse().toString();
                    int idx = i;
                    if ((idx = map.getOrDefault(w2r, i)) != i)
                    {
                        res.add(Arrays.asList(idx, i));
                    }
                }
            }
        }

        return res;
    }

    private boolean isPalindrome(String word)
    {
        int len = word.length();
        for (int i = 0; i < len / 2; i++)
        {
            if (word.charAt(i) != word.charAt(len - i - 1)) { return false; }
        }
        return true;
    }
}
