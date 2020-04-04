package com.practice.cyc.java.leetcode;

import java.util.*;

/**
 * @author: lengyue
 * @decription:
 * @time: 2020/3/29
 */
public class PostOrder {

    /**
     * 后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorder(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.addFirst(node.val);
            for (TreeNode item : node.children) {
                if (item != null) {
                    stack.add(item);
                }
            }
        }
        return output;
    }

    /**
     * 二叉树前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();

        while (root != null) {
            while (root != null) {
                list.add(root.val);
                if (root.right != null) {
                    stack.push(root.right);
                }
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
            }
        }
        return list;
    }

    /**
     * 全排列
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    /**
     * 前序中序构建二叉树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return help(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode help(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        // 构建跟节点
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        // 找到根节点中序遍历的位置
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        // 构建左子树
        root.left = help(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        // 构建右子树
        root.right = help(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }


}
