/**
 * 二叉树的最近公共祖先
 */
public class LeetCode_236_0222 {


    /**
     *
     * 两个节点在左子树中的最近共同祖先是 r，那么当前树的最近公共祖先也就是 r
     * 如果子树中只能找到 p 节点或者 q 节点，它最终返回其实就是 p 节点或者 q 节点。
     * 这其实对应于最后一种情况，也就是 leftCommonAncestor 和 rightCommonAncestor 都不为 null，
     * 说明 p 节点和 q 节点分处于两个子树中，直接 return root
     * 递归
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p ,q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode == null) {
            return rightNode;
        }
        if (rightNode == null) {
            return leftNode;
        }
        return root;
    }

    /**
     * 存在唯一路径p到root，q到root
     * 将遍历过程中每个节点的父节点保存起来
     * 倒着还原 p 的路径，并将每个节点加入到 set 中
     * 倒着遍历 q 的路径，判断是否在 p 的路径中
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorRe(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, TreeNode> relationMap = new HashMap<>();
        stack.push(root);
        relationMap.put(root, null);
        while (!relationMap.containsKey(p) || !relationMap.containsKey(q)) {
            TreeNode cur = stack.pop();
            if (cur.left != null) {
                stack.push(cur.left);
                relationMap.put(cur.left, cur);
            }
            if (cur.right != null) {
                stack.push(cur.right);
                relationMap.put(cur.right, cur);
            }
        }
        Set<TreeNode> treeSet = new HashSet();
        while (p != null) {
            treeSet.add(p);
            p = relationMap.get(p);
        }
        while (q != null) {
            if (treeSet.contains(q)) {
                break;
            }
            q = relationMap.get(q);
        }
        return q;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}