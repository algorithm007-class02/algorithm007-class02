import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=515 lang=java
 *
 * [515] 在每个树行中找最大值
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 1.BFS
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            int tempLargest = Integer.MIN_VALUE;
            for(int i = 0; i < level; i++){
                if(queue.peek().left != null) queue.add(queue.peek().left);
                if(queue.peek().right != null) queue.add(queue.peek().right);
                tempLargest = Math.max(tempLargest, queue.poll().val);
            }
            res.add(tempLargest);
        }
        return res;
    }
}

// 2.DFS
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        DFS(0, root, res);
        return res;
    }
    private void DFS(int level, TreeNode root, List<Integer> res){
        if(root == null) return;
        if(res.size() <= level){
            res.add(root.val);
        }
        res.set(level, Math.max(res.get(level), root.val));
        DFS(level+1, root.left, res);
        DFS(level+1, root.right, res);
    }
}
// @lc code=end

