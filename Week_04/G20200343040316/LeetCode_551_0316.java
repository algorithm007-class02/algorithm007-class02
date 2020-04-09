package com.wxs.algorithm1.week04;

import com.wxs.algorithm.week03.TreeNode;

import java.util.*;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-04
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_551_0316 {


    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);

        TreeNode node3 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);

        node.left =  node2;
        node.right = node3;


        node3.left = new TreeNode(5);
        node3.right = new TreeNode(3);



        node2.right = new TreeNode(9);




        LeetCode_551_0316 largestValues551 = new LeetCode_551_0316();

        largestValues551.largestValues2(node);

    }

    public List<Integer> largestValues(TreeNode root) {


        if (root == null) {
            return Arrays.asList();
        }

        List<Integer> list = new ArrayList<>();

        help(list, root);

        return list;

    }

    private void help(List<Integer> list, TreeNode root) {

        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            int minV = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {

                TreeNode remove = queue.remove();

                minV =  Math.max(minV,remove.val);
                if(remove.left != null){
                    queue.add(remove.left);
                }

                if(remove.right != null){
                    queue.add(remove.right);
                }

            }

            list.add(minV);

        }
    }



    List<Integer> list = new ArrayList<>();

    public List<Integer> largestValues2(TreeNode root) {


        if (root == null) {
            return Arrays.asList();
        }



        help2(0, root);

        return list;

    }

    private void help2(int level, TreeNode root) {

        if (root == null) {
            return;
        }

        if(level == list.size()){
            list.add(root.val);
        }


        int max = Math.max(root.val, list.get(level));
        list.remove(level);
        list.add(level,max);



        help2(level+1,root.left);
        help2(level+1,root.right);
    }

}
