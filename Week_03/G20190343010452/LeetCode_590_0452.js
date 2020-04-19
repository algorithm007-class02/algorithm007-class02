/*
 * @lc app=leetcode.cn id=590 lang=javascript
 *
 * [590] N叉树的后序遍历
 */

// @lc code=start
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

// 递归 O(N)
// var postorder = function (root) {
//   if (!root) return [];

//   const res = [];
//   recusion(root);
//   return res;

//   function recusion(node) {
//     if (!node) return;

//     node.children.forEach(item => {
//       recusion(item);
//     });

//     res.push(node.val);
//   }
// };

// 迭代 O(N)
var postorder = function (root) {
  if (!root) return [];

  const res = [];
  const stack = [root];
  while (stack.length) {
    const curr = stack.pop();
    if (!curr) continue;
    res.push(curr.val);
    stack.push(...curr.children);
  }
  return res.reverse();
}
// @lc code=end