// hard

public class LFUCache {

    class Node
    {
        int freq;
        // 在这个freq下的key的集合，注意，用的是linkedHashSet
        // key在里面是根据insert的顺序排列的
        // 为什么这里用linkedHashSet?
        // 因为查找,插入，删除都是O(1)，并且要求对同一freq,key用LRU的顺序
        // 因此返回的第一个元素就是满足LRU的
        Set<Integer> keys;
        Node pre;
        Node next;

        Node(int freq)
        {
            this.freq = freq;
            this.keys = new LinkedHashSet<>();
        }
    }
    // dummy head, 这个是freq double linked list的开头
    // Node由freq从小到大排列
    private Node head = new Node(-1);
    // dummy tail
    private Node tail = new Node(-1);

    // key value map
    private Map<Integer, Integer> keyVal = new HashMap<>();
    // key Node pair, 通过key得到key对应的freq的那个Node
    private Map<Integer, Node> keyNode = new HashMap<>();

    // capacity
    private int cap;
    // current size
    private int size;

    // ====================================================================
    public LFUCache(int capacity) {
        this.cap = capacity;
        this.size = 0;
        // connect head and tail
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public int get(int key)
    {
        // exist?
        if (!keyVal.containsKey(key)) { return -1; }

        // remove from original Node
        Node n = keyNode.get(key);
        n.keys.remove(key);

        // store in freq + 1 Node
        // freq + 1 node exists?
        Node nNext = n.next;
        if (nNext != null && nNext.freq == n.freq + 1)
        {
            // add into new linkedHashSet, at tail
            nNext.keys.add(key);
        }
        else
        {
            nNext = new Node(n.freq + 1);
            nNext.keys.add(key);
            // insert this new Node into double linked list
            nNext.next = n.next;
            nNext.pre = n;

            n.next = nNext;
            nNext.next.pre = nNext;
        }
        // update
        keyNode.put(key, nNext);

        // original Node is empty? remove this Node
        if (n.keys.isEmpty())
        {
            n.pre.next = n.next;
            n.next.pre = n.pre;
        }

        return keyVal.get(key);
    }

    public void put(int key, int value)
    {
        if (cap == 0) { return; }
        // key already exist? only need update value and freq
        if (keyVal.containsKey(key))
        {
            // update value
            keyVal.put(key, value);
            // reuse get method to update key's freq
            get(key);
            return;
        }

        keyVal.put(key, value);
        // check capacity
        // 如果超过了，先删除一个key-value pair
        if (size >=  cap)
        {
            // 总是从head的下一个Node中删除
            // delete
            Node t = head.next;
            int old = -1;
            // get least recently one
            for (int k : t.keys)
            {
                old = k;
                break;
            }
            t.keys.remove(old);
            keyVal.remove(old);
            // t is empty now？
            // if so, remove this Node as well
            if (t.keys.isEmpty())
            {
                head.next = t.next;
                t.next.pre = head;
                // Java garbage collection will recycle this space
            }
        }

        // add new key to corresponding Node
        Node t = head.next;
        // 才加入的item初始freq设为1
        if (t != null && t.freq == 1)
        {
            t.keys.add(key);
        }
        else
        {
            t = new Node(1);
            t.keys.add(key);
            // insert this new Node
            t.next = head.next;
            t.next.pre = t;

            t.pre = head;
            head.next = t;
        }

        keyNode.put(key, t);
        size++;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
