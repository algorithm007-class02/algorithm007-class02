package com.logic;

import java.util.Hashtable;

/**
 * @Auther: welllu
 * @Date: 2020/5/3 09:08
 * @Description: 1.LinkedHashMap;   2.哈希表 + 双向链表
 */
public class LeeCode_146_0226 {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    /**
     * add node after head
     * @param node
     */
    private void addNode(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode ( node );
        addNode ( node );
    }

    private DLinkedNode popTail() {
        DLinkedNode res = tail.prev;
        removeNode ( res );
        return res;
    }



    private DLinkedNode head;
    private DLinkedNode tail;

    private Hashtable<Integer,DLinkedNode> cache = new Hashtable <> (  );

    private int capacity;
    private int size;


    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode ();
        tail = new DLinkedNode ();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get ( key );
        if(node == null) return -1;
        moveToHead ( node );
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get ( key );
        if(node == null) {
            DLinkedNode node = new DLinkedNode ();
            node.key = key;
            node.value = value;
            cache.put(key,node);
            addNode ( node );

            ++size;
            if(size > capacity) {
                DLinkedNode tail = popTail ();
                cache.remove ( tail.key );
                --size;
            }
        }
    }






}
