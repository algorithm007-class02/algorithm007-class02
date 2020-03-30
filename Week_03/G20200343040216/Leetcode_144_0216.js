/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 */

/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */

// 方法1：递归的方法
/**
 * @param {Node} root
 * @return {number[]}
 */

function dfs(root, res) {
  if (!root) return res;
  res.push(root.val);
  for (var i = 0; i < root.children.length; i++) {
    dfs(root.children[i], res);
  }
}
var preorder = function(root) {
  var res = [];
  dfs(root, res);
  return res;
};

// 方法2： 迭代的方法

var preorder = function(root) {
  if (!root) return [];
  var res = [];
  var stack = [];

  stack.push(root);
  while (stack.length > 0) {
    var last = stack.pop();
    if (last) res.push(last.val);
    

    for (var i = last.children.length - 1; i >= 0; i--) {
      var child = last.children[i];
      if (child !== null) stack.push(child);
    }
  }

  return res;
};