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
  let res = [];
  function helper(root) {
    if (!root) return;
    let children = root.children;
    res.push(root.val);
    for (let i = 0; i < children.length; i++) {
      helper(children[i]);
    }
  }
  helper(root);
  return res;
};
