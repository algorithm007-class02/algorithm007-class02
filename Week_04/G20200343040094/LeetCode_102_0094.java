import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层次遍历
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
// 1.DFS
class Solution {
    public List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(0, root);
        return res;
    }
    private void dfs(int level, TreeNode root){
        if(root == null) return;
        if(res.size() <= level){
            res.add(new LinkedList<>());
        }
        res.get(level).add(root.val);
        dfs(level+1, root.left);
        dfs(level+1, root.right);
    }
}

// 2.BFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return res;
        queue.add(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            List<Integer> tempList = new LinkedList<>();
            for(int i = 0; i < level; i++){
                if(queue.peek().left != null) queue.add(queue.peek().left);
                if(queue.peek().right != null) queue.add(queue.peek().right);
                tempList.add(queue.poll().val);
            }
            res.add(tempList);
        }
        return res;
    }
}
// @lc code=end

