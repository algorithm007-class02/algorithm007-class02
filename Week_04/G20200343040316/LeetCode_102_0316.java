package com.wxs.algorithm1.week04;

import com.wxs.algorithm.week03.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 类描述  ： 按层遍历二叉树
 * 创建人  : 吴绪森
 * 创建时间：2020-04-03
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_102_0316 {



    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        return order(res, root);

    }

    private List<List<Integer>> order(List<List<Integer>> res, TreeNode root) {


        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> list = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode remove = queue.remove();
                list.add(remove.val);


                if (remove.left != null) {
                    queue.add(remove.left);
                }
                if (remove.right != null) {
                    queue.add(remove.right);
                }
            }
            res.add(list);
        }
        return res;

    }


    /**
     * 深度优先遍历，拿到高度，就可以得到外层数组size
     */
    List<List<Integer>> res1 ;

    public List<List<Integer>> levelOrder2(TreeNode root) {

        res1 = new ArrayList<>();
        helper(0, root);
        return res1;
    }

    private void helper(int level, TreeNode root) {

        if(root == null){
            return;
        }

        if(level == res1.size()){
            res1.add(new ArrayList<>());
        }

        res1.get(level).add(root.val);

        if(root.left != null){
            helper(level+1,root.left);
        }

        if(root.right != null){
            helper(level+1,root.right);
        }

    }


}
