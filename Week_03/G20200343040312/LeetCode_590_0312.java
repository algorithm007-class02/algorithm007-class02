//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
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
}
*/

import java.util.ArrayList;
import java.util.List;

class Solution590 {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return list;
    }

    public void helper(Node root, List list){
        if (root==null){
            return;
        }
        //核心
//        int nums = root.children.size();
//        for (int i=0; i<nums; i++){
//            helper(root.children.get(i),list);
//        }
        //下面这种循环方式感觉更好
        for(Node child: root.children){
            helper(child,list);
        }
        list.add(root.val);
    }
    /*
     * 耗时1ms（100%），使用内存41M（5%）*/
}
//leetcode submit region end(Prohibit modification and deletion)
