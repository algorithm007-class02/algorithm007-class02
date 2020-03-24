1.使用IntelliJ查看java源码的方法
  在已经配置好JDk的项目目录列表中，找到External Libraries，点开版本号文件夹（eg."<1.8.0_231>"）-->rt.jar-->java，这里就是所选版本的java源码了
  
2.想更加快捷迅速地查看代码吗？
  想面对一大片javadoc一目了然吗？
  试试ctrl+shift+"-"/ctrl+shift+"+"
  以折叠/展开IntelliJ方法和注释

2.Queue是继承于Collection的接口，其所拥有的方法有
  boolean add(E e);  插入元素，有“容量”则返回true，没有容量则抛出错误IllegalStateException
  boolean offer(E e);  插入元素，有“容量”则返回true，没有容量则返回null
  E remove();  取出（返回并删除）头部元素。若无头部元素，返回NoSuchElementException
  E poll();  取出（返回并删除）头部元素。若无头部元素，返回null
  E element();  查看头部元素。仅返回头部元素，不删除。无头部元素时返回NoSuchElementException
  E peek();  查看头部元素。仅返回头部元素，不删除。无头部元素时返回null
  
  两套操作的主要区别是是否进行安全检查，
  进行安全检查的有：add();remove();element();
  不进行安全检查的有offer();poll();peek();

3.public interface Queue<E> extends Collection<E>
  队列是一个继承于父类的接口，而队列也是由基础数据结构构成的。
  父类Collection中的，Collections.addAll()方法就可以将Java数组转换为Queue，如下
  
  而父类Collection中的Object[] toArray();方法可以将队列变为数组
  Returns an array containing all of the elements in this collection.如下
	import java.util.Collections;
	import java.util.LinkedList;
	import java.util.Queue;

	public class text {
		public static void main(String[] args) {
			String nums[] = {"A", "B", "C", "D", "E"};
			Queue<String> queue = new LinkedList<>();
			Collections.addAll(queue, nums);
			System.out.println(queue);

			String change[] = queue.toArray(new String[nums.length]);
			System.out.print("循环输出数组");
			for (int i=0; i<nums.length; i++){
				System.out.print(","+change[i]);
			}
		}
	}
	结果打印为：
	[A, B, C, D, E]
	循环输出数组,A,B,C,D,E

4.Queue作为接口，它有很多很多实现类：
	AbstractQueue, ArrayBlockingQueue, ArrayDeque, ConcurrentLinkedDeque, ConcurrentLinkedQueue, DelayQueue, LinkedBlockingDeque, LinkedBlockingQueue, LinkedList, LinkedTransferQueue, PriorityBlockingQueue, PriorityQueue, SynchronousQueue
  我们可以把他们分为“有界队列”和“无界队列“、“阻塞队列”和“非阻塞队列”。（来源于网络资料）
	有界队列：有容量限制，在创建时需要设置队列的大小。eg,ArrayBlockingQueue
	无界队列：没有容量限制，在创建时不需设置大小.eg，LinkedList
	阻塞队列：实现BlockingQueue 接口的所有队列都是阻塞队列。它们会一直阻塞，直到它的工作完成
	
  
  