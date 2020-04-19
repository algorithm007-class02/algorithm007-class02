/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
 func preorderTraversal(root *TreeNode) []int {
    if root == nil {
        return nil
    }
    
    var ret []int
    var stack []*TreeNode
    stack = append(stack, root)
    for {
        if len(stack) == 0 {
            break
        }
        e:=stack[len(stack)-1]
        ret = append(ret, e.Val)
        stack = stack[:len(stack)-1]
        if e.Right != nil {
            stack = append(stack, e.Right)
        }
        if e.Left != nil {
            stack = append(stack, e.Left)
        }
    }
    return ret
}
