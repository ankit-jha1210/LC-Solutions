class DLLNode {
    int key, val;
    DLLNode prev;
    DLLNode next;

    public DLLNode(int key, int val) {
        this.val = val;
        this.key = key;
    }
}

class LRUCache {
    HashMap<Integer, DLLNode> map;
    DLLNode head, tail;
    int size;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.size = capacity;
        head = new DLLNode(0, -1);
        tail = new DLLNode(0, -1);
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DLLNode node = map.get(key);
            int val = node.val;
            remove(node);
            insert(new DLLNode(key, val));
            return val;
        } else return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == size) remove(tail.prev);

        insert(new DLLNode(key, value));
    }

    public void insert(DLLNode node) {
        map.put(node.key, node);
        DLLNode headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }

    public void remove(DLLNode node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
