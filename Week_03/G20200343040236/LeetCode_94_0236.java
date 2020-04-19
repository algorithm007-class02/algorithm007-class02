import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
class LeetCode_94_0236{
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        if(root == null) return list;
        reduce(list,root);
        return list;
    }

    public void reduce(List<Integer> list ,TreeNode root ){
        if(root.left != null){
            reduce(list,root.left);
        }
        list.add(root.val);
        if(root.right != null){
            reduce(list,root.right);
        }
    }
}