import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/description/
 *
 * algorithms
 * Easy (72.10%)
 * Likes:    57
 * Dislikes: 0
 * Total Accepted:    18.4K
 * Total Submissions: 25.4K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其后序遍历: [5,6,3,2,4,1].
 * 
 * 
 * 
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
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
        List<Integer> list = new ArrayList<>();
        
        postnode( list , root);
        return list;
        
    }

    private void postnode(List<Integer> list, Node root) {
        if (root == null) {
            return;
        }
        for (Node val : root.children) {
            if (val != null) {
                postnode( list , val); 
            }
        }
        list.add(root.val);
    }
}
// @lc code=end

