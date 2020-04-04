/*
 * @Author: mingxing.huang
 * @Date: 2020-03-28 17:00:08
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
var inorderTraversal = function(root) {
  // 二叉树中序遍历：左根右
  let res = [];
  inorder(root);
  return res;

  function inorder(root) {
    if (root) {
      inorder(root.left);
      res.push(root.val);
      inorder(root.right);
    }
  }
};
