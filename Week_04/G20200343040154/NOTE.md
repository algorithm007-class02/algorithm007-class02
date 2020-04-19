学习笔记

队列
### priority_queue 最大堆、最小堆
* 需要注意的是，C++ STL默认的priority_queue是将优先级最大的放在队列最前面，也即是最大堆。那么如何实现最小堆呢？
* 假设有如下一个struct：
```
假设有如下一个struct：
struct Node {
    int value;
    int idx;
    Node (int v, int i): value(v), idx(i) {}
    friend bool operator < (const struct Node &n1, const struct Node &n2) ; 
};

inline bool operator < (const struct Node &n1, const struct Node &n2) {
    return n1.value < n2.value;
}

priority_queue<Node> pq; // 此时pq为最大堆
```
如果需要最小堆，则需要如下实现：
```
struct Node {
    int value;
    int idx;
    Node (int v, int i): value(v), idx(i) {}
//  friend bool operator < (const struct Node &n1, const struct Node &n2) ;
    friend bool operator > (const struct Node &n1, const struct Node &n2) ;
}; 

inline bool operator > (const struct Node &n1, const struct Node &n2) {
    return n1.value > n2.value;
}

priority_queue<Node, vector<Node>, greater<Node> > pq; // 此时greater会调用 > 方法来确认Node的顺序，此时pq是最小堆
```
简单对比：
```
/**
默认比较函数为less, 大顶堆
**/
priority_queue<int> q;

/**
使用greater比较函数，小顶堆
**/
priority_queue<int, vector<int>, greater<int> > q;

====== 

// priority_queue默认是最大堆，要用最小堆需要比较函数greater<int>
priority_queue<int, vector<int>, less<int>> maxHeap;
priority_queue<int, vector<int>, greater<int>> minHeap;

```
