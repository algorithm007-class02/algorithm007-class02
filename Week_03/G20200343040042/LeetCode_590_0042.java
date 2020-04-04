package com.yequan.leetcode.tree.ntreepostorder_590;

import com.yequan.leetcode.tree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * //给定一个 N 叉树，返回其节点值的后序遍历。
 * //
 * // 例如，给定一个 3叉树 :
 * //
 * //
 * //
 * //
 * //
 * //
 * //
 * // 返回其后序遍历: [5,6,3,2,4,1].
 * //
 * //
 * //
 * // 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树
 * <p>
 * <p>
 * //leetcode submit region begin(Prohibit modification and deletion)
 *
 * // Definition for a Node.
 * class Node {
 *      public int val;
 *      public List<Node> children;
 *      public Node() {}
 *      public Node(int _val) {
 *          val = _val;
 *      }
 *      public Node(int _val, List<Node> _children) {
 *          val = _val;
 *          children = _children;
 *      }
 * }
 *
 * @author :Administrator
 * @date :2020/3/27
 */

public class NTreePostorder {

    public List<Integer> postorder(Node root) {
        List<Integer> res=new ArrayList<>();
        helper(root,res);
        return res;
    }

    private void helper(Node root, List<Integer> res) {
        if (null!=root){
            if (null!=root.children){
                for (Node child : root.children) {
                    helper(child,res);
                }
                res.add(root.val);
            }
        }
    }


}
