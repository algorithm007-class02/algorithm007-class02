import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 广度优先遍历模板代码 List<Integer> values = new ArrayList<>(); Queue<Node> queue = new
 * LinkedList<>(); queue.add(root); while (!queue.isEmpty()) { Node nextNode =
 * queue.remove(); values.add(nextNode.val); for (Node child :
 * nextNode.children) { queue.add(child); } }
 */

/*
429. N叉树的层序遍历
给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

例如，给定一个 3叉树 :

            1
         /  |  \ 
        /   |   \   
        3   2    4
      /  \ 
     /    \
    5      6
返回其层序遍历:

[
     [1],
     [3,2,4],
     [5,6]
]
 

说明:

树的深度不会超过 1000。
树的节点总数不会超过 5000。
*/


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

// class Solution {
//     public List<List<Integer>> levelOrder(Node root) {
//         List<List<Integer>> ans = new ArrayList<>();
//         if (root == null) {
//             return ans;
//         }
//         LinkedList<Node> queue = new LinkedList<>();
//         queue.add(root);
//         while (!queue.isEmpty()){
//             int size = queue.size();
//             List<Integer> level = new ArrayList<>();
//             for (int i = 0; i < size; i++) {
//                 Node node = queue.remove();
//                 level.add(node.val);
//                 queue.addAll(node.children);
//             }
//             ans.add(level);
//         }
//         return ans;
//     }
// }

class Solution {
  
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        dfs(ans, root, 0);
        return ans;
    }
    private void dfs(List<List<Integer>> ans, Node node, int level) {
        if (ans.size() <= level) {
            List<Integer> levelList = new ArrayList<>();
            ans.add(levelList);
        }
        ans.get(level).add(node.val);
        if (node.children == null) {
            return;
        }
        for (Node child : node.children) {
            dfs(ans, child, level+1);
        }
    }
}