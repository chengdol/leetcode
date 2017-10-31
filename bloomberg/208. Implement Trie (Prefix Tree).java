// medium


class Trie {

    // word 最后一个字母 后 还接了一个node, node.end = true
    class Node
    {
        // use map more generic
        Map<Character, Node> map;
        boolean end;

        Node()
        {
            end = false;
            map = new HashMap<>();
        }
    }

    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word)
    {
        insertHelper(word, 0, root);
    }

    private void insertHelper(String w, int idx, Node n)
    {
        if (idx == w.length())
        {
            n.end = true;
            return;
        }

        char c = w.charAt(idx);
        // next char
        Node next = n.map.getOrDefault(c, new Node());
        n.map.put(c, next);

        insertHelper(w, idx + 1, next);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word)
    {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String w, int idx, Node n)
    {
        // base cases
        if (idx == w.length())
        {
            return n.end;
        }

        char c = w.charAt(idx);
        if (!n.map.containsKey(c)) { return false; }

        return searchHelper(w, idx + 1, n.map.get(c));
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix)
    {
        return startHelper(prefix, 0, root);
    }

    private boolean startHelper(String p, int idx, Node n)
    {
        if (idx == p.length()) { return true; }

        char c = p.charAt(idx);
        if (!n.map.containsKey(c)) { return false; }

        return startHelper(p, idx + 1, n.map.get(c));
    }
}

