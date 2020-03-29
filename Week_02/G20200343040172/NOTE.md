学习笔记
总结了第二周所使用到的一些新用到的语法或者是数据结构
## TreeMap
[Java 11 TreeMap](
https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/TreeMap.html)
1. java.lang.Object
2. java.lang.Objectjava.util.AbstractMap<K,V>
3. java.util.TreeMap<K,V>

> A Red-Black tree based NavigableMap implementation. The map is sorted according to the natural ordering of its keys, or by a Comparator provided at map creation time, depending on which constructor is used.
> This implementation provides guaranteed log(n) time cost for the containsKey, get, put and remove operations. Algorithms are adaptations of those in Cormen, Leiserson, and Rivest's Introduction to Algorithms

|Modifier and Type|Method|Description|
|---|---|---|
|Map.Entry<K,V>|lastEntry()|Returns a key-value mapping associated with the greatest key in this map, or null if the map is empty|
|Map.Entry<K,V>|pollLastEntry()|Removes and returns a key-value mapping associated with the greatest key in this map, or null if the map is empty|
|V|getOrDefault()|Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key|

## Comparator
####  int compare (T o1, T o2)
>Compares its two arguments for order. Returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.

> Throws:
> NullPointerException : if an argument is null and this comparator does not permit null arguments
> ClassCastException : if the arguments' types prevent them from being compared by this comparator.

| Return | Meanning | 
| --- | --- | 
| negative integer | o1<o2|
| zero | o1=o2|
|  positive integer | o1>o2 | 

## Priority Queue
Priotity Queue默认使用小顶堆，通过重写比较器让其变为大顶堆
```
// 默认是小根堆，实现大根堆需要重写一下比较器。  
Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
```

## Greedy Algorithm
该题可以使用贪心算法来解
> https://leetcode-cn.com/problems/longest-palindrome/


## Hash Map执行流程
[image](https://uploader.shimo.im/f/l5dVSGWUPF0bc54l.png!thumbnail)
