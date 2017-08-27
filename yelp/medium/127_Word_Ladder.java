// medium

// 我用的最基本的BFS，但很慢
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        if (wordList == null || wordList.size() == 0) { return 0;}

        Queue<String> que = new ArrayDeque<>();
        Map<String, Integer> wordLevel = new HashMap<>();
        // init
        for (String w : wordList) { wordLevel.put(w, Integer.MAX_VALUE); }

        // add begin word, level start from 1
        // 长度是word的个数，不是路径数
        wordLevel.put(beginWord, 1);

        que.offer(beginWord);
        while (!que.isEmpty())
        {
            String w = que.poll();
            int nextLevel = wordLevel.get(w) + 1;

            for (int i = 0; i < w.length(); i++)
            {
                StringBuilder sb = new StringBuilder(w);
                // 26种可能，若wordList的长度比26大，则这种方法快一些
                for (char c = 'a'; c <= 'z'; c++)
                {
                    sb.setCharAt(i, c);
                    String next = sb.toString();

                    // exist in dic?
                    if (wordLevel.containsKey(next))
                    {
                        // arrive end word
                        if (next.equals(endWord)) { return nextLevel; }

                        // 找到更短的路径才压入queue中
                        if (nextLevel < wordLevel.get(next))
                        {
                            // update
                            wordLevel.put(next, nextLevel);
                            que.offer(next);
                        }
                    }
                }
            }
        }

        return 0;
    }
}
