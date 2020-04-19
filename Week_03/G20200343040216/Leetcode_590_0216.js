/**
 * 给定一个二叉树，返回它的 前序 遍历。
 */

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

// 方法1：递归的方法
/**
 * @param {Node} root
 * @return {number[]}
 */

function dfs(root, res) {
  if (!root) return res;
  res.push(root.val);
  dfs(root.left, res);
  dfs(root.right, res);
}
var preorderTraversal = function(root) {
  var res = [];

  if (!root) return [];

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

    if(last.right !== null) { // 为什么先入右根，记住栈的特性，先入后出
      stack.push(last.right)
    }
   if(last.left !== null) {
     stack.push(last.left)
   }

  }

  return res;
};
