<?php


 // Definition for a binary tree node.
class TreeNode {
    public $val = null;
    public $left = null;
    public $right = null;
    function __construct($value) { $this->val = $value; }
}
 

/**
 *  参考题解
 */ 
class Solution {

    /**
     * @param TreeNode $root
     * @return Integer[]
     */
    function preorderTraversal($root) {
        $res = [];
        if ($root == null) return $res;

        $this->task($root, $res);

        return $res;
    }

    public function task($node, &$res)
    {
        if ($node == null) return $res;

        $res[] = $node->val;
        $this->task($node->left, $res);
        $this->task($node->right, $res);
    }
}
