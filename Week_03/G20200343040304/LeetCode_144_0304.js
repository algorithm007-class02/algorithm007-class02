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
var preorderTraversal = function (root) {
  if (!root) return [];

  let results = [];
  recursion(root);
  function recursion(root) {
    const { left, right, val } = root;
    results.push(val);

    if (left) {
      recursion(left);
    }

    if (right) {
      recursion(right);
    }
  }

  return results;
};