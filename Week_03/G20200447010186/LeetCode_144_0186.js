/**
 * 题目：给定一个二叉树，返回它的 前序 遍历。
 * @param {TreeNode} root
 * @return {number[]}
 */

/**
 * 解法1: 经典递归法
 */
var preorderTraversal = function(root) {
  const res = [];
  function print(root) {
    // terminator
    if (!root) return;
    // current next level：直接对左右节点执行同样的函数,如果这一层已经没有左右节点，则下一层的时候会直接返回
    res.push(root.val);
    print(root.left);
    print(root.right);
  }
  // 记得初始调用
  print(root);
  return res;
};
