/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Children []*Node
 * }
 */

 func levelOrder(root *Node) [][]int {
    if root == nil {
        return nil
    }
   var ret [][]int
   var stack []*Node
   var stack2 []*Node
   stack = append(stack, root)
   for {
       if len(stack) == 0 {
           break
       }
       var retLevel []int
       for i:=0; i<len(stack); i++ {
           retLevel = append(retLevel, stack[i].Val)
           for j:=0; j<len(stack[i].Children); j++ {
               stack2 = append(stack2, stack[i].Children[j])
           }
       }
       ret = append(ret, retLevel)
       stack = stack[:0]
       stack = append(stack, stack2...)
       stack2 = stack2[:0]
   }

   return ret
}
