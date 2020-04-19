package com.yequan.leetcode.tree.ntreepreorder_589;

import com.yequan.leetcode.tree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Administrator
 * @date : 2020/3/27
 */
public class NTreePreorder {


    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(Node root, List<Integer> res) {
        if (null != root) {
            res.add(root.val);
            if (null != root.children) {
                for (Node child : root.children) {
                    helper(child, res);
                }
            }
        }
    }

}
