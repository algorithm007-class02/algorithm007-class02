/*
 * @Author: mingxing.huang
 * @Date: 2020-03-28 17:07:52
 */
/**
 * N叉树的后序遍历
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */
var postorder = function(root) {
  // 后序遍历：左右根
  let res = [];
  fn(root);
  return res;

  function fn(root) {
    if (root) {
      for (let node of root.children) {
        fn(node);
      }
      res.push(root.val);
    }
  }
};
