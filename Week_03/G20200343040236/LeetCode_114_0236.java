import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
class LeetCode_114_0236{
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        if(root == null) return list;
        reduce(list,root);
        return list;
    }

    public void reduce(List<Integer> list ,TreeNode root ){
        list.add(root.val);
        if(root.left != null){
            reduce(list,root.left);
        }
        if(root.right != null){
            reduce(list,root.right);
        }
    }
}