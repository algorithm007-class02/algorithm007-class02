1.public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }
  put函数直接调用putVal的返回值
  ↓↓↓
      final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
	1）首先对储存元素的table进行判断，如果table为空，那么就通过resize()对字段进行初始化。
	2）然后如果hashcode获取的值为空，就建立一个新节点，p为进过哈希函数计算出来的hashcode对应的数组中的元素。
	3）如果新插入的节点和table中p节点的hashcode值和key值相同的话。e = p;
	
	4）如果是红黑树，进行红黑树插入e = (...).putTreeVal(...);
	
	5）这里else中的for指，当这个单链表只有一个头结点时，要新建一个节点。
	
	6）++modCount; 指更改操作次数
	
	7）如果size大于临界值，就要将数组大小设置为原来的2倍
	
	
2.  public V get(Object key) {
        Node<K,V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }
	
	↓↓↓
    final Node<K,V> getNode(int hash, Object key) {
        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & hash]) != null) {
            if (first.hash == hash && // always check first node
                ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.next) != null) {
                if (first instanceof TreeNode)
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                do {
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }
	要在HashMap中存入，先要判断key与hashcode的数组是否为空。不为空则继续。
	hashcode可能大于数组的长度，因此通过与运算保证得出的hashcode小于数组长度。然后将hashcode赋值给first。然后，对k做判断，相同则返回first，不同则获取下一个节点是否为空，若下一个节点部位空则继续判断是否是树的实例，如果是，则要获取树节点，不是的话就要循环获取节点，直到找到相同的key节点为止。
	