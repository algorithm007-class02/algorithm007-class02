学习笔记


一、队列

Queue 是个接口，它提供的 add, offer 方法初衷是希望子类能够禁止添加元素为 null，这样可以避免在查询时返回 null 究竟是正确还是错误。 事实上大多数 Queue 的实现类的确响应了 Queue 接口的规定，比如 ArrayBlockingQueue，PriorityBlockingQueue 等等。虽然 LinkedList 没有禁止添加 null，但是一般情况下 Queue 的实现类都不允许添加 null 元素，为啥呢？因为 poll(), peek() 方法在异常的时候会返回 null，你添加了 null　以后，当获取时不好分辨究竟是否正确返回。
Queue 一般都是 FIFO 的，但是也有例外，比如优先队列 priority queue（它的顺序是根据自然排序或者自定义 comparator
不论进入、出去的先后顺序是怎样的，使用 remove()，poll() 方法操作的都是头部的元素；而插入的位置则不一定是在队尾了，不同的 queue 会有不同的插入逻辑。
PriorityQueue 优先级队列，Java实现是一个小顶堆。不是线程安全的，add方法没有做异常检查，因为priorityQueue是无限增长的队列，不会添加失败。
二、HashMap
java7 : 结构是entry数组+链表实现的，且初始长度为16 扩容后是当前的2倍，负载因子0.75(也是避免hash碰撞)。并且是单向链表。
java8 ：数组+链表+红黑树为了解决hash碰撞后，链表时间复杂度为O(n), 为了减低开销，Java8在达到8时，转成红黑树，查询是可以降低到O(logn)
问题点：
多线程下使用HashMap容易出现的问题：

多线程扩容，死循环（扩容死循环，实际是循环链表，1.8死循环已经解决。1.7是头插法，新的链表和原来是倒着的）
多线程put可能丢元素 。
put非null，get却为null。
注意点：

key可以使用null。