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
  //传入前序和中序，返回根节点及左右子树
  function fun(preorder, inorder) {
      let tree = new TreeNode(preorder[0])
      //终止条件：序列长度为0
      if (preorder.length === 0) {
          return null;
      }
      //处理当前层逻辑：找到根节点在中序中的位置
      const index = inorder.findIndex(item => item === preorder[0]);
      //下一层：得到左右子树
      tree.left = fun(preorder.slice(1, index + 1), inorder.slice(0, index));
      tree.right = fun(preorder.slice(index + 1), inorder.slice(index + 1));

      return tree;
  }
  return fun(preorder, inorder);
};