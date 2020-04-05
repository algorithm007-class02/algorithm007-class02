/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
 func buildTree(preorder []int, inorder []int) *TreeNode {
    if len(preorder) == 0 {
        return nil
    }

    var root int
    for i := range inorder {
        if inorder[i] == preorder[0] {
            root = i
            break
        }
    }

    return &TreeNode{
        Val:   preorder[0],
        Left:  buildTree(preorder[1: root+1], inorder[0: root]),
        Right: buildTree(preorder[root+1:], inorder[root+1:]),
    }
}
