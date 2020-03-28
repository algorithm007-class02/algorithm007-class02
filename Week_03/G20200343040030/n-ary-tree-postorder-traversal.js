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
    for (let i = 0; i < children.length; i++) {
      helper(children[i]);
    }
    res.push(root.val);
  }
  helper(root);
  return res;
};
