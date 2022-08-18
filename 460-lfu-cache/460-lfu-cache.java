class LFUCache {
    int currSize, minFreq;
    final int capacity;
    Map<Integer, DoubleLinkedList> freqMap;
    Map<Integer, Node> cache;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        freqMap = new HashMap<>();
        cache = new HashMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if(node == null) return -1;
        updateNode(node);
        return node.value;
    }

    void updateNode(Node node) {
        // update the frequency list
        int currFreq = node.freq;
        DoubleLinkedList lst = freqMap.get(currFreq);
        lst.removeNode(node);
        if (currFreq == minFreq && lst.listSize == 0) {
            minFreq++;
        }
        node.freq++;
        DoubleLinkedList newList = freqMap.getOrDefault(node.freq, new DoubleLinkedList());
        newList.insertNode(node);
        freqMap.put(node.freq, newList);
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            updateNode(node);
        } else {
            currSize++;
            if (currSize > capacity) {
                DoubleLinkedList minFreqList = freqMap.get(minFreq);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                currSize--;
            }
            minFreq = 1;
            Node newNode = new Node(key, value);
            DoubleLinkedList newList = freqMap.getOrDefault(1, new DoubleLinkedList());
            newList.insertNode(newNode);
            freqMap.put(1, newList);
            cache.put(key, newNode);
        }
    }
}

class Node {
    int key, value;
    Node prev, next;
    int freq;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}

class DoubleLinkedList {
    Node head, tail;
    int listSize;

    public DoubleLinkedList() {
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        this.listSize = 0;
    }

    void insertNode(Node node) {
        Node headNext = head.next;
        node.next = headNext;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        listSize++;
    }

    void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        listSize--;
    }
}