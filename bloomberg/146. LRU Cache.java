// hard

// common question
// 记住使用的数据结构: inner Node class(key,value) and doubly-linkd list
public class LRUCache {

    // inner node class
    class Node
    {
        int key;
        int val;
        Node pre;
        Node next;

        Node(int key, int val, Node pre, Node next)
        {
            this.key = key;
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }

    // instance variables
    private Map<Integer, Node> map;
    // we need two nodes as boundary
    private Node head;
    private Node tail;
    private int cap;

    // helper methods
    // add right after dummy
    private void addNodeToHead(Node n)
    {
        // be careful
        n.next = head.next;
        head.next = n;

        n.next.pre = n;
        n.pre = head;
    }

    // fetch selected node
    private Node fetchNodeOut(Node n)
    {
        n.pre.next = n.next;
        n.next.pre = n.pre;
        // clean
        n.next = null;
        n.pre = null;

        return n;
    }

    // delete redundant node
    private Node deleteNodeAtEnd()
    {
        Node n = tail.pre;
        n.pre.next = tail;
        tail.pre = n.pre;

        // clean
        n.next = null;
        n.pre = null;
        return n;
    }

    // =================================
    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.cap = capacity;

        head = new Node(0, 0, null, null);
        tail = new Node(0, 0, head, null);
        head.next = tail;
    }

    public int get(int key) {
        Node n = map.getOrDefault(key, null);
        if (n == null) { return -1; }
        // reorder
        n = fetchNodeOut(n);
        addNodeToHead(n);


        return n.val;
    }

    public void put(int key, int value) {
        // exist?
        Node n = map.getOrDefault(key, null);
        if (n != null)
        {
            n.val = value;
            // reorder
            n = fetchNodeOut(n);
            addNodeToHead(n);
            return;
        }

        n = new Node(key, value, null, null);
        // exceeds
        // be careful >= not >!!!
        if (map.size() == cap)
        {
            Node tmp = deleteNodeAtEnd();
            // delete corresponging item in map
            map.remove(tmp.key);
        }
        addNodeToHead(n);
        map.put(key, n);
    }
}
