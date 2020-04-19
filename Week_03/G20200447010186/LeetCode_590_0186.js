/**
 * 题目：给定一个 N 叉树，返回其节点值的后序遍历。
 * @param {Node} root
 * @return {number[]}
 */

/**
 * 解法1: 经典递归
 */

var postorder = function(root) {
  const res = [];

  function print(root) {
    if (!root) return;
    // current
    for (let i of root.children) {
      // next level
      if (i.children) {
        print(i);
      }
    }

    res.push(root.val);
  }

  print(root);
  return res;
};
