//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=105 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     public $val = null;
 *     public $left = null;
 *     public $right = null;
 *     function __construct($value) { $this->val = $value; }
 * }
 */
class Solution {

    private $preorder;
    private $inorder;
    private $pmap = [];
    private $pre_idx = 0;
    /**
     * 方法一：递归
     * @param Integer[] $preorder
     * @param Integer[] $inorder
     * @return TreeNode
     */
    function buildTree($preorder, $inorder) {
        $this->preorder = $preorder;
        $this->inorder = $inorder;
        $this->pmap = array_flip($inorder);
        return $this->helper(0, count($preorder));
    }

    function helper($left_index, $right_index) {
        if ($left_index == $right_index) return null;
        $val = $this->preorder[$this->pre_idx];
        $this->pre_idx++;
        $root = new TreeNode($val);
        $index = $this->pmap[$val];
        $root->left = $this->helper($left_index, $index);
        $root->right = $this->helper($index + 1, $right_index);
        return $root;
    }
}
// @lc code=end
