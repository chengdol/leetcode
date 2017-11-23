// medium

/*
Implement a magic directory with buildDict, and search methods.

For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.

For the method search, you'll be given a word, and judge whether if you modify exactly one character into another character in this word, the modified word is in the dictionary you just built.

Example 1:
Input: buildDict(["hello", "leetcode"]), Output: Null
Input: search("hello"), Output: False
Input: search("hhllo"), Output: True
Input: search("hell"), Output: False
Input: search("leetcoded"), Output: False
*/
// no idea
class MagicDictionary {

    Map<String, Character> map;
    /** Initialize your data structure here. */
    public MagicDictionary() 
    {
        map = new HashMap<>();    
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) 
    {
        for (String word : dict)
        {
            StringBuilder sb = new StringBuilder(word);
            for(int i = 0; i < sb.length(); i++)
            {
                sb.setCharAt(i, '*');
                String tmp = sb.toString();
                // 若有相同的形式，则value设置为*
                // 这样若search时遇到必行是满足的！
                if (map.containsKey(tmp))
                {
                    map.put(tmp, '*');
                }
                else
                {
                    map.put(tmp, word.charAt(i));
                }
                // restore
                sb.setCharAt(i, word.charAt(i));
            }
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) 
    {
        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < sb.length(); i++)
        {
            sb.setCharAt(i, '*');
            String tmp = sb.toString();
            if (map.containsKey(tmp))
            {
                // 检查是什么char
                char val = map.get(tmp);
                if (val == '*' || val != word.charAt(i))
                {
                    return true;
                }
            }
            // restore
            sb.setCharAt(i, word.charAt(i));
            
        }
        
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */