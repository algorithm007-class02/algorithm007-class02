package level2;

import tools.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 栈应用于深度优先搜索
public class Solution429 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> levels = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                levels.add(node.val);
                queue.addAll(node.children);
            }
            res.add(levels);
        }
        return res;
    }

    // 递归 关键是保存数据的列表需要全局定义
    // 按层保存数据
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder1(Node root) {
        if (root == null)
            return res;
        loopHelper(root, 0);
        return res;
    }

    public void loopHelper(Node node, int level) {
        if (node != null) {
            if (res.size() <= level) {
                res.add(new ArrayList<>());
            }
            res.get(level).add(node.val);
            for (Node child : node.children) {
                loopHelper(child, level + 1);
            }
        }
    }

}
