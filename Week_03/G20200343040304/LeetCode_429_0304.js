/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder = function (root) {
  if (!root) return [];
  let results = {};
  function recursion(node, level) {
    const { children, val } = node;
    const next = (results[level] || []).concat(node.val);
    results[level] = next;

    if (children) {
      children.forEach(child => {
        recursion(child, level + 1);
      });
    }
  }

  recursion(root, 0);

  return Object.values(results)
};