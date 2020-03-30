//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=94 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
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
    private $result = [];
    /**
     * 方法一：递归
     * 时间复杂度：O(n)
     * 最坏情况下需要空间O(n)，平均情况为O(logn)
     * @param TreeNode $root
     * @return Integer[]
     */
    function inorderTraversal1($root) {
        $this->inorder($root);
        return $this->result;
    }
    function inorder($root) {
        if (!$root) {
            $this->inorder($root->left);
            $this->result[] = $root->val;
            $this->inorder($root->right);
        }
    }
    /**
     * 方法二：迭代(栈)
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param TreeNode $root
     * @return Integer[]
     */
    function inorderTraversal2($root) {
        $result = [];
        $stack = [];
        $curr = $root;
        while ($curr || $stack) {
            while ($curr) {
                $stack[] = $curr;
                $curr = $curr->left;
            }
            $curr = array_pop($stack);
            $result[] = $curr->val; 
            $curr = $curr->right;    
        }
        return $result;
    }
    /**
     * 方法三：迭代(颜色标记法)[使用bool代替颜色]
     * 1.使用颜色标记节点的状态，新节点为白色，已访问的节点为灰色。
     * 2.如果遇到的节点为白色，则将其标记为灰色，然后将其右子节点、自身、左子节点依次入栈。
     * 3.如果遇到的节点为灰色，则将节点的值输出。
     * @param TreeNode $root
     * @return Integer[]
     */
    function inorderTraversal3($root) {
        $result = [];
        $stack = [[$root, true]];
        while ($stack) {
            [$curr, $flag] = array_pop($stack);
            if (!$curr) continue;
            if ($flag) {
                $stack[] = [$curr->right, true];
                $stack[] = [$curr, false];
                $stack[] = [$curr->left, true];
            } else {
                $result[] = $curr->val;
            }
        }
        return $result;
    }
    /**
     * 方法4：莫里斯遍历
     * 思想
     * 若current没有左子节点
     *  a. 将current添加到输出
     *  b. 进入右子树，亦即, current = current.right
     * 否则
     *  a. 在current的左子树中，令current成为最右侧节点的右子节点
     *  b. 进入左子树，亦即，current = current.left
     * @param TreeNode $root
     * @return Integer[]
     */
    function inorderTraversal($root) {
        $result = [];
        $curr = $root;
        while ($curr) {
            if ($curr->left) {
                $pre = $curr->left;
                while ($pre->right) {
                    $pre= $pre->right;
                }
                $pre->right = $curr;
                //重要
                $tmp = $curr;
                $curr = $curr->left;
                $tmp->left = null;
            } else {
                $result[] = $curr->val;
                $curr = $curr->right;
            }
        }
        return $result;
    }
}
// @lc code=end
