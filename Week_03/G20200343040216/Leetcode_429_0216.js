/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */

function dfs (root, level, res) {
  if(!root) return res;

  if(res.length <= level ) {
    res.push([])
  }

  res[level].push(root.val)
  if (!root.children) return res;

  for(var i = 0; i < root.children.length; i++) {
    var child = root.children[i];
    if(child) {
      bfs(child, level + 1, res)
    }
  }
}
/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    var res = [];
    dfs(root, 0, res);

    return res;
};