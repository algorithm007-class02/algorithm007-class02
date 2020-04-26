## 高级树、AVL 树和红黑树概念
### 二叉树的三种遍历
1. 前序(Pre-order)：根-左-右
2. 中序(In-order)：左-根-右
3. 后序(Post-order)：左-右-根

### 二叉搜索树
二叉搜索树，是指一棵空树或者具有下列性质的二叉树：
1. 左子树上所有结点的值均小于它的根结点的值
2. 右子树上所有结点的值均大于它的根结点的值
3. 以此类推：左、右子树也分别为二叉查找树

`二叉树的中序遍历就是其升序排列`

###平衡二叉树
#### 为什么出现平衡二叉树？
二叉树的查找只与树的高度有关，为了避免因左右子树不平衡（高度不一致）影响二叉树的性能，比如极端情况下退化为链表，因此需要动态地来平衡左右子树的高度。

#### AVL树（严格平衡二叉树）
左子树的高度减去它的右子树的高度（有时相反），只能有三种取值：{-1, 0, 1}

#### 红黑树（近似平衡二叉树）
红黑树是一种近似平衡的二叉搜索树（Binary Search Tree），它能够确保任何一个结点的左右子树的高度差小于两倍。即`从根到叶子的最长的可能路径不多于最短的可能路径的两倍长`。关键性质具体来说，红黑树是满足如下条件的二叉搜索树：
- 每个结点要么是红色，要么是黑色
- 根节点是黑色
- 每个叶节点（NIL节点，空节点）是黑色的。
- 不能有相邻接的两个红色节点
- 从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点。

#### AVL和红黑树的比较
- AVL trees provide faster lookups than Red Black Trees because they are more strictly balanced.【AVL的查询效率比红黑树更高，因为它是一种严格的平衡二叉树】
- Red Black Trees provide faster insertion and removal operations than AVL trees as fewer rotations are done due to relatively relaxed balancing.【红黑树的插入和删除的操作的效率比AVL树更高，因为红黑树的旋转次数更少，它不需要维持严格的平衡】
- AVL trees store balance factors or heights with each node, thus requires storage for an integer per node whereas Red Black Tree requires only 1 bit of information per node.【AVL树每个节点都需要存储平衡因子以及树的高度，因此每个节点需要一个字节的开销，而红黑树每个节点只需要1个bit的开销】
- Red Black Trees are used in most of the language libraries like map, multimap, multisetin C++ whereas AVL trees are used in databases where faster retrievals are required.【红黑树大部分都是用在一些语言的库中，比如map，multimap，multisetin C++，而AVL树主要用在数据库这种对检索速率要求更高的场景中】