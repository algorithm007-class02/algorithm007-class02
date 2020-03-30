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
var preorder = function(root) {
  if(!root) return []
  const result = [];
  const _preorder = (node) => {
      if (!node) return;
      result.push(node.val);
      node.children.forEach(item => _preorder(item))
  }
  _preorder(root)
  return result;
};