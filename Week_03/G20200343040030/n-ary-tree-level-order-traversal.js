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
var levelOrder = function(root) {
  if (!root) return [];
  let res = [];
  let queue = [root];
  while (queue.length > 0) {
    let len = queue.length;
    let level = [];
    for (let i = 0; i < len; i++) {
      let current = queue.shift();
      level.push(current.val);
      if (current.children.length) queue.push(...current.children);
    }
    res.push(level);
  }

  return res;
};
