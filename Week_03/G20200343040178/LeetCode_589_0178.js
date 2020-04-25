/*
 * @Author: mingxing.huang
 * @Date: 2020-03-28 17:22:06
 */
/**
 * N叉树的前序遍历
 * // Definition for a Node.
 * function Node(val, children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */
var preorder = function(root) {
  // 前序遍历：根左右
  let res = [];
  fn(root);
  return res;

  function fn(root) {
    if (root) {
      res.push(root.val);
      for (let child of root.children) {
        fn(child);
      }
    }
  }
};
