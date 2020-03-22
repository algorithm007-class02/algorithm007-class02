1.Deque是继承于Queue的一个接口类，属于无界队列

2.Deque的基础方法
	addfirst();removefirst();getrfirst();//addlast();removelast();elementlast();

	removeFirst()：移除链表中第一个元素，与remove类似
	对应的有 removeLast()
	boolean removeFirstOccurrence(Object o);从队列中删除该元素第一次出现的位置上的元素
	对应的有 removeLastOccurrence(Object o)
	
	get(int index)：按照下标获取元素
	getFirst()：获取第一个元素
	与之对应的有getLast()
	
	push();---This method is equivalent to addFirst(E).
	pop();---This method is equivalent to removeFirst().
	poll();---查询并移除第一个元素
	
	peek();just look
	对应的有 peekFirst();peekLast();
	
	boolean offer(E e)：在链表尾部插入一个元素 ≈ addfirst ，区别于，offer插入失败返回null
	offerFirst();offerLast();
	
	iterator();将元素按从头到尾的顺序返回。
	descendingIterator();将元素按从尾到头的顺序返回。
	
	实现的是Collection的接口，
	size();返回元素的数量。
	
3.LinkedList对Deque的实现
	
	提供有参数和无参数构造两种构造方法
    public LinkedList(Collection<? extends E> c) {
        this();
        addAll(c);
    }
	
	随后，LinkedList();linkFirst();linkLast();linkBefore();通过前驱后驱节点将一个个Node组织在一起。
	
	add系列和remove系列与比较常规，就是对Link与unlink系列的调用。
	offer系列和pop系列同理，它们是调用add和remove系列。
	
	清空链表
    public void clear() {

        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
        modCount++;
    }