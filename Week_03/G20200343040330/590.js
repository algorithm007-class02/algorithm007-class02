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
var postorder = function(root) {
  if(!root) return []
  let result = [];
  const dfs = (node) => {
      if(!node) {
          return
      }
      node.children.forEach(item => dfs(item))
      result.push(node.val)
  }
  dfs(root);
  return result;
};
