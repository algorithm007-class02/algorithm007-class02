class LRUCache {

    private class Node {
        private int key;
        private int val;
        Node next;
        Node pre;
    }

    private Node head,tail;
    private int capacity;
    private HashMap<Integer, Node> nodeMap = new HashMap();

    private void addNode(Node node) {
        node.pre = head;
        node.next = head.next;
        node.next.pre = node;
        head.next = node;
    }

    private void delNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if (null != node) {
            delNode(node);
            addNode(node);
        }
        return null == node ? -1 : node.val;
    }

    public void put(int key, int value) {
        Node node = nodeMap.get(key);
        if (null == node) {
            node = new Node();
            node.key = key;
            node.val = value;
            nodeMap.put(key, node);
            if (nodeMap.size() > capacity) {
                nodeMap.remove(tail.pre.key);
                delNode(tail.pre);
            }
        } else {
            node.val = value;
            delNode(node);
        }

        addNode(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */