/**
 * 题目：二叉搜索树的中序遍历
 * @param {TreeNode} root
 * @return {number[]}
 *
 * root为TreeNode对象结构，具有left、right、val属性
 */

/**
 * 解法1:经典递归法 O(n)
 * 先判断左子树一直到左子树的叶子节点
 * 然后打印出的第一个值永远是最底层左子树的左节点
 */
var inorderTraversal = function(root) {
  const res = [];

  helper(root, res);
  function helper(root, res) {
    if (root !== null) {
      if (root.left !== null) {
        helper(root.left, res);
      }
      // 打印根值.
      res.push(root.val);
      if (root.right !== null) {
        helper(root.right, res);
      }
    }
  }
  return res;
};

/**
 * 解法2:递归法简化
 */
var inorderTraversal = function(root) {
  const res = [];
  const print = root => {
    if (!root) return;
    print(root.left);
    res.push(root.val);
    print(root.right);
  };
  // 首次执行一下
  print(root);
  return res;
};

/**
 * 解法3:栈方法 O(n)
 * 维护一个栈，依次根据访问路径往栈内存放节点
 * 当当前节点左子节点为空，说明到底了，弹出该节点值，并打印
 *
 */
var inorderTraversal = function(root) {
  const res = [];
  const stack = [];

  // 一直沿左子树递归查找，并不断入栈.当current.left不存在时跳出
  // 先判断root，避免一开始就走不进该条件
  while (root || stack.length > 0) {
    while (root !== null) {
      stack.push(root);
      root = root.left;
    }

    root = stack.pop();
    res.push(root.val);
    root = root.right;
  }
};
