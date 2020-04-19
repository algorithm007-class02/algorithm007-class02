/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function(root, p, q) {
  // 思路
  // 两个节点p,q分为两种情况：
  // p和q在相同子树中
  // p和q在不同子树中
  // 从根节点遍历，递归向左右子树查询节点信息

  // 递归终止条件：如果当前节点为空或等于p或q，则返回当前节点
  if (!root || root == p || root === q) return root;

  // 递归遍历左右子树；
  let left = lowestCommonAncestor(root.left, p, q);
  let right = lowestCommonAncestor(root.right, p, q);
  //   如果左右子树查到节点都不为空，则表明p和q分别在左右子树中，因此，当前节点即为最近公共祖先
  if (left && right) return root;
  // 如果左右子树其中一个不为空，则返回非空节点。
  return left ? left : right;
};
