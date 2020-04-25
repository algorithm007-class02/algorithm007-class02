/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
 // 二叉树的前序遍历
var preorderTraversal = function(root) {
    var result = []
    preorder(result, root)
    return result
};

var preorder = function(result, root) {
    if(!root) {
        return result
    }
    result.push(root.val)
    preorder(result, root.left)
    preorder(result, root.right)
    return result
}