package binaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author VITI.lewis
 * @Despriction:
 * @Date:Created in 2020/3/29 9:59 下午
 * @Modify By:
 */
public class binaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<Integer>();
        }
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        nodeStack.push(root);
        List<Integer> list = new ArrayList<Integer>();

        while(nodeStack.size() != 0 ){
            TreeNode node = nodeStack.pop();
            list.add(node.val);
            if(node.right != null) {
                nodeStack.push(node.right);
            }
            if(node.left != null) {
                nodeStack.push(node.left);
            }
        }
        return list;
    }
}
