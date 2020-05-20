import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 利用双链表
 */
class LRUCache {

    class Node{
        int key;
        int value;
        Node prev;
        Node next;
    }

    private void addNode(Node node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(Node node){
        removeNode(node);
        addNode(node);
    }

    private Node popTail(){
        Node res = tail.prev;
        removeNode(res);
        return res;
    }

    private Hashtable<Integer,Node> cache = new Hashtable<Integer,Node>();
    private int size;
    private int capacity;
    private Node head,tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if(node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if(node == null){
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;

            cache.put(key,newNode);
            addNode(newNode);

            size++;

            if(size > capacity){
                Node tail = popTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
}

/**
 * 利用java的LinkedHashMap
 */
class LRUCache1 extends LinkedHashMap<Integer,Integer> {

    private int capacity;

    public LRUCache1(int capacity) {
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        super.put(key,value);
    }

    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
        return size() > capacity;
    }
}