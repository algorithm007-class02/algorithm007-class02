class Solution {
    /**
     * 解法一：队列遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            int sizeL = queue.size();
            for (int i = 0; i < sizeL; i++) {
                Node cur = queue.pollFirst();
                l.add(cur.val);
                queue.addAll(cur.children);
            }
            res.add(l);
        }
        return res;
    }
}