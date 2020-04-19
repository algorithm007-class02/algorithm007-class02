package com.wxs.algorithm1.week03;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 类描述  ：中序遍历
 * 创建人  : 吴绪森
 * 创建时间：2020-03-26
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_94_0316 {


    public static void main(String[] args) {
        LeetCode_94_0316 inorderTraversal94 = new LeetCode_94_0316();


    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        inorder(list,root);

        return list;
    }


    /**
     *  时间复杂度：O(n) ，
     *  空间复杂度 一般是 O(logn), 退还成链表的复杂度 O(logn)
     * @param list
     * @param node
     */
    public void  inorder(List<Integer> list, TreeNode node){
        if(node == null ){
            return;
        }

        inorder(list,node.left);
        list.add(node.val);
        inorder(list,node.right);

    }


    /**
     *  递归方式其实就是在栈中创建栈帧，直到函数调用结束，依次返回，也就是后进先出 FILO
     *  时间空间复杂度都为 O(n)
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;


        while (curr != null || !stack.empty()){

            // 当返回了右节点不为空后，再放入栈内
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }


        return list;


    }



}
