class Solution {
    public List<List<Integer>> levelOrder(Node root) {
       List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if(root == null)
            return resultList;
        Deque<Node> deque = new LinkedList<>();
        Deque<Node> afterDeque = new LinkedList<>();
        deque.add(root);
        Node temp = null;
        while(!deque.isEmpty()){
            afterDeque = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            while(!deque.isEmpty()){
                temp = deque.poll();
                list.add(temp.val);
                afterDeque.addAll(temp.children);
            }
            resultList.add(list);
            deque = afterDeque;
        }
        return resultList;
    }
}