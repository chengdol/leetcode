// medium


// using trie easy to do
class WordDictionary {

    class Node
    {
        boolean end;
        Map<Character, Node> container;

        Node()
        {
            container = new HashMap<>();
            end = false;
        }
    }

    private Node root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word)
    {
        createWordTrie(word.toCharArray(), 0, root);
    }

    private void createWordTrie(char[] word, int idx, Node n)
    {
        if (idx == word.length) { n.end = true; return; }

        Node next = n.container.getOrDefault(word[idx], new Node());
        n.container.put(word[idx], next);

        createWordTrie(word, idx + 1, next);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word)
    {
        return searchHelper(word.toCharArray(), 0, root);
    }

    private boolean searchHelper(char[] word, int idx, Node n)
    {
        if (n == null) { return false; }
        if (idx == word.length) { return n.end; }

        char c = word[idx];
        if (c != '.')
        {
            return searchHelper(word, idx + 1, n.container.get(c));
        }

        boolean find = false;
        for (Node next : n.container.values())
        {
            find = find || searchHelper(word, idx + 1, next);
        }
        return find;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
