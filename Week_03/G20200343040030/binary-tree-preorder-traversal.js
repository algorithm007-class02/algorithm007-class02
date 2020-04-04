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
  let res = [];
  function helper(root) {
    if (!root) return;
    res.push(root.val);
    helper(root.left);
    helper(root.right);
  }

  helper(root);

  return res;
};
