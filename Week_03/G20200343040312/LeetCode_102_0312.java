//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索

/*
* 感觉可以直接将输入以一个两个三个的方式直接存入list然后输出233*/

/*深度优先遍历（DFS）分为“前序、中序、后序
* 宽度优先遍历（BFS）就是层序遍历
*
* 虽然层序遍历就是宽度优先遍历
* 但是在这里，我们用depth来控制（是否在Lists中重建新的list）
* 因为depth（深度）是从上到下，从0开始，而一开始的Lists的size也是0
* */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
//    List<List<Integer>> lists = new ArrayList<List<Integer>>();
//
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        /*
//        * 递归（DFS写法）
//        * 运行结果有问题，先暂放*/
//        if (root==null) {return lists;}
//        helper(root,0);
//        return lists;
//    }
//
//    private void helper(TreeNode root, int depth) {
//
//        if (lists.size()==depth){
//            lists.add(new ArrayList<Integer>());
//        }
//        lists.get(depth).add(root.val);
//
//        if (root.left!=null){
//            helper(root.left,depth++);
//        }
//        if (root.right!=null){
//            helper(root.right,depth++);
//        }
//    }
    /*
     * 耗时0ms（100%），使用内存36.9M（5%）*/

    public List<List<Integer>> levelOrder(TreeNode root){
        //声明二维数组
        List<List<Integer>> lists = new ArrayList<>();
        if (root==null){return lists;};

        //bfs使用队列,队列存放每层的结点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            List<Integer> eachfloor = new ArrayList<>();
            for (int i=0; i<queue.size(); i++){
                TreeNode node = queue.poll();
                eachfloor.add(node.val);
                if (node.left!=null){ queue.add(node.left); }
                if (node.right!=null){ queue.add(node.right); }
            }
            lists.add(eachfloor);
        }
        return lists;
    }
    /*
     * 耗时1ms（93%），使用内存40M（6%）*/
}
//leetcode submit region end(Prohibit modification and deletion)
