学习笔记

改写详见 UpdateDequeExample.java 文件

1.分析Queue 和 Priority Queue 的源码

Queue是一个继承自Collection集合类的接口类，在集合的基础上添加了增删改查操作 并且队列默认使用先进先出规则。

队列不允许插入null元素，
需要实现的方法：
- add(E e) 插入一个元素到队列中，失败时返回IllegalStateException （队列容量不够）
- offer(E e) 插入一个元素到队列中，失败时返回false
- remove() 返回并移除队列的头部元素
- poll() 返回并移除队列的头部元素，队列为空时返回null
- element() 返回队列头部的元素
- peek() 返回队列头部的元素，队列为空时返回null

PriorityQueue 优先队列继承自接口Queue
优先队列中的元素在逻辑上构成了一棵完全二叉树，实际存储时转换为数组存在内存中。
由以下结构属性构成

//默认用于存储节点信息的数组的大小
private static final int DEFAULT_INITIAL_CAPACITY = 11;
//用于存储节点信息的数组
transient Object[] queue;
//数组中实际存放元素的个数
private int size = 0;
//Comparator比较器
private final Comparator<? super E> comparator;
//用于记录修改次数的变量
transient int modCount = 0;

还有数个构造方法，就是需要指定初始化数组的容量和比较器

- add,offer方法中需要注意的是，当数组没有可用空间了，会调用grow方法扩容
- grow方法会根据情况判断应该怎么扩容，以64为准 如果原数组较小则会扩大两倍，否则增加50%容量
插入新元素时如果二叉树不为空，会调用siftUp方法添加新元素调整结构，保持堆的结构
- remove方法删除一个节点，首先该方法会获取到最后一个节点的索引并判断删除元素是否为最后一个节点，如果是则直接删除即可。
如果删除索引不是最后一个位置，那么首先会获取到最后一个节点的值并将其删除，
紧接着将最后一个节点的值覆盖掉待删位置的节点值并调整结构，调整完成之后，
会判断queue[i] == moved，如果为true表示新增元素之后并没有调整结构（满足堆结构），
那么就会向上调整结构。（如果向下调整过结构自然是不需要再向上调整了），
如果queue[i] != moved值为true表示向上调整过结构，那么将会返回moved。
- peek方法获取队头元素 比较好懂
- poll方法出队头节点的同时维持堆结构，首先判断该队中是否有元素，如果没有则直接返回null，
否则分别获取头节点的值和末节点的值，删除尾节点并将尾节点的值替换头节点的值，
接着向下调整结构，最后返回被删除的头节点的值。
- 优先队列提供隐式的比较器，你也可以自行定义比较器来进行有序输出

2.HashMap 小总结
HashMap：它根据键的hashCode值存储数据，大多数情况下可以直接定位到它的值，因而具有很快的访问速度，但遍历顺序却是不确定的。
桶 拉链
除了超哥提到的知识点，我小小的补充几个

- HashMap最多只允许一条记录的键为null，允许多条记录的值为null。HashMap非线程安全，即任一时刻可以有多个线程同时写HashMap，可能会导致数据的不一致。
如果需要满足线程安全，可以用 Collections的synchronizedMap方法使HashMap具有线程安全的能力，或者使用ConcurrentHashMap。
- 扩容是一个特别耗性能的操作，所以当程序员在使用HashMap的时候，估算map的大小，初始化的时候给一个大致的数值，避免map进行频繁的扩容。
- JDK1.8引入红黑树大程度优化了HashMap的性能。
