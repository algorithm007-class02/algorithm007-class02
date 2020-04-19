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
  let ans = [];
  function fun(tree, n) {
      //终止条件
      if (tree === null) return;
      //当前逻辑
      ans[n] ? ans[n].push(tree.val) : ans[n] = [tree.val];
      //下一层
      tree.children.forEach(child => {
          fun(child, n + 1);
      })
  }
  fun(root, 0);
  return ans;
};