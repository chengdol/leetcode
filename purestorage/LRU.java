// hard

class LRUCache {

    class Node
    {
        int key;
        int val;
        Node pre;
        Node next;

        Node(int key, int val)
        {
            this.key = key;
            this.val = val;
            pre = next = null;
        }
    }

    private Map<Integer, Node> map;
    private int cap;
    // dummy head and tail
    private Node head;
    private Node tail;


    public LRUCache(int capacity)
    {
        // initialize instance variables
        map = new HashMap<>();
        cap = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        // connect
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key)
    {
        if (!map.containsKey(key)) { return -1; }
        Node n = map.get(key);
        // update doubly linked list
        remove(n);
        addAtHead(n);
        // return val
        return n.val;
    }

    private void remove(Node n)
    {
        n.pre.next = n.next;
        n.next.pre = n.pre;

        n.pre = n.next = null;
    }

    private void addAtHead(Node n)
    {
        n.next = head.next;
        n.pre = head;

        head.next.pre = n;
        head.next = n;
    }

    public void put(int key, int value)
    {
        if (map.containsKey(key))
        {
            // update value and position
            Node n = map.get(key);
            n.val = value;
            get(key);
            return;
        }

        // create new node
        Node n = new Node(key, value);
        if (map.size() >= cap)
        {
            if (cap == 0) { return; }

            // remove least used Node
            Node t = removeLeastNode();
            map.remove(t.key);
            // System.out.println(t.key);
        }
        // add right after head
        addAtHead(n);
        map.put(key, n);
    }

    private Node removeLeastNode()
    {
        Node n = tail.pre;
        remove(n);
        return n;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
