//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=144 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 链接：
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
     * @param TreeNode $root
     * @return Integer[]
     */
    function preorderTraversal1($root) {
        $this->preorder($root);
        return $this->result;
    }
    function preorder($root) {
        if ($root) {
            $this->result[] = $root->val;
            $this->preorder($root->left);
            $this->preorder($root->right); 
        }
    }

    /**
     * 方法二：迭代（颜色标记法）
     * @param TreeNode $root
     * @return Integer[]
     */
    function preorderTraversal2($root) {
        $result = [];
        $stack = [[$root, true]];
        while ($stack) {
            [$curr, $flag] = array_pop($stack);
            if (!$curr) continue;
            if ($flag) {
                $stack[] = [$curr->right, true];
                $stack[] = [$curr->left, true];
                $stack[] = [$curr, false];
            } else {
                $result[] = $curr->val;
            }
        }
        return $result;
    }

    /**
     * 方法三：迭代（栈）
     * @param TreeNode $root
     * @return Integer[]
     */
    function preorderTraversal3($root) {
        $result = [];
        $stack = [$root];
        while ($stack) {
            $curr = array_pop($stack);
            if (!$curr) continue;
            $result[] = $curr->val;
            $curr->right && $stack[] = $curr->right;
            $curr->left && $stack[] = $curr->left;
        }
        return $result;
    }

    /**
     * 方法四：莫里斯遍历
     * @param TreeNode $root
     * @return Integer[]
     */
    function preorderTraversal($root) {
        $result = [];
        $curr = $root;
        while ($curr) {
            if (!$curr->left) {
                $result[] = $curr->val;
                $curr = $curr->right;
            } else {
                $pre = $curr->left;
                while ($pre->right && $pre->right != $curr) {
                    $pre  = $pre->right;
                }
                if (!$pre->right) {
                    $result[] = $curr->val;
                    $pre->right = $curr;
                    $curr = $curr->left;
                } else {
                    $pre->right = null;
                    $curr = $curr->right;
                }
            }
        }
        return $result;
    }
}
// @lc code=end
