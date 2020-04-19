/*
 * @Author: mingxing.huang
 * @Date: 2020-03-28 21:56:58
 */
/**
 * N叉树的层序遍历
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
  // 递归
  let res = [];
  if (root) {
    fn(0, root);
  }
  return res;

  function fn(level, root) {
    if (res.length <= level) {
      // 每一层都用一个数组来存数据
      res.push([]);
    }
    // 通过level，找到对应的数组，存放节点
    res[level].push(root.val);
    for (let child of root.children) {
      fn(level + 1, child);
    }
  }
};
