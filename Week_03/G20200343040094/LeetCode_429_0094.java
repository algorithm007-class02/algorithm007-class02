import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N叉树的层序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        dfs_levelOrder(root, res, 0);
        return res;
    }
    private void dfs_levelOrder(Node root, List<List<Integer>> res, int level){
        if(res.size() == level){
            res.add(new LinkedList<>());
        }
        res.get(level).add(root.val);
        for(Node child: root.children){
            dfs_levelOrder(child, res, level+1);
        }
    }
}
// @lc code=end

