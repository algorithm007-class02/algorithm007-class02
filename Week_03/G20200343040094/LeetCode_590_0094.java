import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
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
    public List<Integer> postorder(Node root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        dfs_postorder(root, res);
        return res;
    }
    private void dfs_postorder(Node root, List<Integer> res){
        if(root == null) {
            return;
        }
        for(Node child: root.children){
            dfs_postorder(child, res);
        }
        res.add(root.val);
    }
}
// @lc code=end

