### 新的API改写Deque的代码
````
Deque<String> deque = new LinkedList<String>();
deque.addFirst("a");
deque.addFirst("b");
deque.addFirst("c");
System.out.println(deque);
String str = deque.getFirst();
System.out.println(str);
System.out.println(deque);
while (deque.size() > 0) {
    System.out.println(deque.pollFirst());
}
System.out.println(deque);
````
### PriorityQueue源码分析
实现原理：使用数组实现二叉堆
二叉堆定义（百度百科）： 
二叉堆是一种特殊的堆，二叉堆是完全二元树（二叉树）或者是近似完全二元树（二叉树）。  
二叉堆有两种：最大堆和最小堆。  
最大堆：父结点的键值总是大于或等于任何一个子节点的键值；  
最小堆：父结点的键值总是小于或等于任何一个子节点的键值。  
二叉堆一般用数组来表示，如果存储数组的下标基于0，那么下标为i的节点的子节点是2i+1与2i+2；其父节点的下标是floor((i−1)∕2)，函数floor(x)的功能是“向下取整”。

PriorityQueue的定义
````
public class PriorityQueue<E> extends AbstractQueue<E>
    implements java.io.Serializable {
    private static final int DEFAULT_INITIAL_CAPACITY = 11;

    /**
     * 存放数据的数组
     */
    transient Object[] queue; 

    /**
     * 队列元素个数
     */
    private int size = 0;

    /**
     * 比较器
     */
    private final Comparator<? super E> comparator;

    /**
     * 修改次数
     */
    transient int modCount = 0;
    
    public PriorityQueue(int initialCapacity,
                         Comparator<? super E> comparator) {
        //初始化容量校验
        if (initialCapacity < 1)
            throw new IllegalArgumentException();
        this.queue = new Object[initialCapacity];//定义数组
        this.comparator = comparator;//初始化比较器
    }
    
     /**
      * 添加元素
      */
    public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();
        modCount++;
        int i = size;
        if (i >= queue.length)//当前元素个数大于等于数组长度则数组进行扩容
            grow(i + 1);
        size = i + 1;//队列元素个数增1
        if (i == 0)
            queue[0] = e;
        else
            siftUp(i, e);//非首个元素添加，则在尾部添加元素后“上移”处理
        return true;
    }
    
     /**
      * 添加元素元素后“上移”处理
      * 上移至其大于等于父结点
      */
    private void siftUp(int k, E x) {
        if (comparator != null)
            //根据比较器来比较元素
            siftUpUsingComparator(k, x);
        else
            //根据元素自身实现的Comparable接口来比较元素
            siftUpComparable(k, x);
    }
    
    private void siftUpComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>) x;
        while (k > 0) {
            int parent = (k - 1) >>> 1; //父节点角标(k - 1)/2
            Object e = queue[parent];
            //新增的元素k比其父亲e大，则不需要"上移"，跳出循环结束
            if (key.compareTo((E) e) >= 0)
                break;
            queue[k]=e;//新增元素小于父节点，则父节点下移（和父元素交换位置）
            k = parent;//k进行上移
        }
        queue[k] = key;
    }
    
    //同上，只是使用了比较器来比较元素大小
    private void siftUpUsingComparator(int k, E x) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            if (comparator.compare(x, (E) e) >= 0)
                break;
            queue[k] = e;
            k = parent;
        }
        queue[k] = x;
    }
    
     /**
      * 删除并返回头元素
      */
    public E poll() {
        if (size == 0)
            return null;
        int s = --size;
        modCount++;
        E result = (E) queue[0];//头元素
        E x = (E) queue[s];//尾元素
        queue[s] = null;
        if (s != 0)
            siftDown(0, x);//尾元素从根结点处下移
        return result;
    }
    
    private void siftDown(int k, E x) {
        if (comparator != null)
            siftDownUsingComparator(k, x);
        else
            siftDownComparable(k, x);
    }
    
    private void siftDownComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>)x;
        int half = size >>> 1; //队列原始的一半
        //下移至叶子结点即可，如果k小于half，则k位置的元素就不是叶子节点
        while (k < half) {
            int child = (k << 1) + 1; //左节点
            Object c = queue[child];
            int right = child + 1;//右节点
            //如果左右节点都存在的话，比较左右节点大小，小节点所在位置则是下移的位置
            if (right < size &&
                ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0)
                //如果右节点小则c=右节点，child=右节点角标
                c = queue[child = right];
            //如果队尾元素比根节点的孩子节点都要小，则不需"下移"，结束
            if (key.compareTo((E) c) <= 0)
                break;
            //和孩子节点交换位子
            queue[k] = c;
            k=child;//将根元素位置k指向最小孩子的位置，进入下层循环
        }
        queue[k] = key;
    }
}
````
