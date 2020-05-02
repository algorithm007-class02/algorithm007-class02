class LRUCache {
    private int capacity;
    private DoubleLinkedList head;
    private DoubleLinkedList tail;
    private Map<Integer, DoubleLinkedList> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new DoubleLinkedList(0, 0);
        this.tail = new DoubleLinkedList(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DoubleLinkedList res = cache.get(key);
        if (null == res) {
            return -1;
        } else {
            moveToHead(res);
            return res.value;
        }
    }

    public void put(int key, int value) {
        DoubleLinkedList node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            node = new DoubleLinkedList(key, value);
            cache.put(key, node);
            addNode(node);
            if (cache.size() > this.capacity) {
                int removeKey = removeTail();
                cache.remove(removeKey);
            }
        }
    }

    private void addNode(DoubleLinkedList node) {
        node.prev = head;
        node.next = head.next;

        head.next = node;
        node.next.prev = node;
    }

    private int removeTail() {
        DoubleLinkedList tailPrev = tail.prev;
        removeNode(tailPrev);
        return tailPrev.key;
    }

    private void removeNode(DoubleLinkedList node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DoubleLinkedList node) {
        removeNode(node);
        addNode(node);
    }

    class DoubleLinkedList {
        int key;
        int value;
        DoubleLinkedList prev;
        DoubleLinkedList next;

        DoubleLinkedList(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}