//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.ArrayList;
import java.util.List;

class Solution589 {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return list;
    }

    private void helper(Node root, List<Integer> list) {
        if (root==null){
            return;
        }
        list.add(root.val);
        for (Node child:root.children){
            helper(child,list);
        }
    }
    /*
     * 耗时1ms（99%），使用内存40.9M（5%）*/
}
//leetcode submit region end(Prohibit modification and deletion)
