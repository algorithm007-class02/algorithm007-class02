<?php

/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     public $val = null;
 *     public $left = null;
 *     public $right = null;
 *     function __construct($value) { $this->val = $value; }
 * }
 */

// 此版本未通过，还在调试中

// class Solution {


// 	private $node;

//     /**
//      * @param TreeNode $root
//      * @param TreeNode $p
//      * @param TreeNode $q
//      * @return TreeNode
//      */
//     function lowestCommonAncestor($root, $p, $q) {
//         $this->recurseTree($root, $p, $q);
//         return $this->node;
//     }


//     private function recurseTree($currentNode, $p, $q) {
//     	if ($currentNode == null) {
//     		# code...
//     		return false;
//     	}

//     	$left = $this->recurseTree($currentNode->left, $p, $q) ? 1 : 0;

//     	$right = $this->recurseTree($currentNode->right, $P, $q) ? 1 : 0;

//     	$mid = ($currentNode == $p || $currentNode == $q) ? 1 : 0;

//     	if ($mid + $left + $right >= 2) {
//     		# code...
//     		$this->node = currentNode;
//     	}
//     }
// }