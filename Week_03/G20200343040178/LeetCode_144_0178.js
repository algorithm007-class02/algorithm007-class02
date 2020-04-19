/*
 * @Author: mingxing.huang
 * @Date: 2020-03-28 17:06:12
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var preorderTraversal = function(root) {
  // 二叉树前序遍历：根左右
  let res = [];
  preorder(root);
  return res;

  function preorder(root) {
    if (root) {
      res.push(root.val);
      preorder(root.left);
      preorder(root.right);
    }
  }
};
