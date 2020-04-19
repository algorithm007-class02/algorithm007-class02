/**
 * Definition for TreeNode.
 * type TreeNode struct {
 *     Val int
 *     Left *ListNode
 *     Right *ListNode
 * }
 */
 func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
    if root == nil {
        return  nil
    }
    if root == p || root == q {
        return root
    }
    root.Left  = lowestCommonAncestor(root.Left, p, q)
    root.Right = lowestCommonAncestor(root.Right, p, q)
    if root.Left != nil && root.Right != nil {
        return root
    }
    if root.Left  != nil {
        return root.Left
    }
    if root.Right != nil {
        return root.Right
    }
    return nil
}
