Queue在java中的定义为泛型Interface
1.特性为FIFO

2.操作

Exception形态API

	add(e)
	remove()
	element()
	
Return value 形态API

	offer(e)
	poll();
	peek();

3.实现

接口层面

3.1 继承的父级接口

	Collection<E> 集合接口
	Iterable<E> 可迭代
	
3.2 派生的接口

	Deque<E>
	BlockingDeque<E>
	BlockingQueue<E>
	TransferQueue<E>
3.3 实现的类

	AbstractQueue
	ArrayBlockingQueue
	ArrayDeque,
	ConcurrentLinkedDeque
	ConcurrentLinkedQueue
	DelayQueue
	LinkedBlockingDeque
	LinkedBlockingQueue
	LinkedList
	LinkedTransferQueue
	PriorityBlockingQueue
	PriorityQueue
	SynchronousQueue

简而言之，在java中队列这种数据结构被抽象定义为了很基础的数据操作行为，其可以由数组、（单双向）链表等各种实现版本，并在此基础上基于工程上的高并发和多线程同步的实际需求考虑实现了各种并行、阻塞的版本。
