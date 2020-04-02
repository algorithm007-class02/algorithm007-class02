/**
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
var postorder = function (root) {
  if (!root) {
    return [];
  }

  let results = [];
  recursion(root);

  function recursion(root) {
    const { children, val } = root;
    children.forEach(child => recursion(child))
    results.push(val);
  }

  return results;
};