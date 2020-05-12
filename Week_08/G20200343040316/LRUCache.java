package com.wxs.algorithm1.week08;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {


    LinkedHashMap<Integer, Integer> map = null;


    public LRUCache(int capacity) {

        map = new LinkedHashMap<Integer, Integer>(100, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {

        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}