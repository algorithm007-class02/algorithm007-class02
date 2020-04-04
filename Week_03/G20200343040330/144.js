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
  if(!root) return [];
  const result = [];
  const _preorderTraversal = (node) => {
      if(!node) return
      result.push(node.val);
      if(node.left) {
          _preorderTraversal(node.left)
      }
      if(node.right) {
          _preorderTraversal(node.right)
      }
  }
  _preorderTraversal(root)
  return result;
};