/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function (root, p, q) {
  if (!root) return false;
  let r = null;
  function recursion(node) {
    if (!node) {
      return false;
    }
    const { left, right } = node;
    let current = (node === p || node === q) ? 1 : 0;

    const lStatus = recursion(left) ? 1 : 0;
    const rStatus = recursion(right) ? 1 : 0;

    if (current + lStatus + rStatus >= 2) {
      r = node;
    }

    return (current + lStatus + rStatus) >= 1;
  }

  recursion(root);
  return r;
};