/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Children []*Node
 * }
 */

 func postorder(root *Node) []int {
    return iteration(root)
}

func iteration(root *Node) []int {
    if root == nil {
        return nil
    }
    var stack []*Node
    var ret []int
    stack = append(stack, root)
    for {
        if len(stack) == 0 {
            break
        }
        e := stack[len(stack)-1]
        ret = append(ret, e.Val)
        stack = stack[:len(stack)-1]
        if len(e.Children) > 0 {
            stack = append(stack, e.Children...)
        }
    }

    var i, j int
    j = len(ret) - 1
    for i < j{
        ret[i], ret[j] = ret[j], ret[i]
        i++
        j--
    }

    return ret
}

func recursive(root *Node) []int {
    if root == nil {
        return nil
    }
    var ret []int
    for i := range root.Children {
        if root.Children[i].Children != nil {
            ret = append(ret, recursive(root.Children[i])...)
        }
    }
    ret = append(ret,root.Val)
    return ret
}
