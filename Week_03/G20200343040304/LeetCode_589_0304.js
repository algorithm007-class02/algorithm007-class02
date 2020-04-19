/**
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
var preorder = function (root) {
  if (!root) return [];

  let results = [];
  recursion(root);
  function recursion(root) {
    const { children, val } = root;
    results.push(val);
    children.forEach(child => recursion(child));
  }

  return results;
};