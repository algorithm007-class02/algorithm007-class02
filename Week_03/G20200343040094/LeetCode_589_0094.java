/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
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
    public List<Integer> preorder(Node root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        dfs_preorder(root, res);
        return res;
    }
    private void dfs_preorder(Node root, List<Integer> res){
        if(root == null){
            return;
        }
        res.add(root.val);
        for (Node child: root.children){
            dfs_preorder(child, res);
        }
    }
}
// @lc code=end

