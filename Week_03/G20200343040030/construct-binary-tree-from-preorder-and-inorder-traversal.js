/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
var buildTree = function(preorder, inorder) {
  if (preorder.length == 0) return null;
  //前序遍历的第一个是跟节点
  let temp = preorder[0];
  //中序遍历的根节点左侧是左子树，右侧是右子树
  let mid = inorder.indexOf(temp);
  let root = new TreeNode(temp);
  root.left = buildTree(preorder.slice(1, 1 + mid), inorder.slice(0, mid));
  root.right = buildTree(preorder.slice(mid + 1), inorder.slice(mid + 1));

  return root;
};
