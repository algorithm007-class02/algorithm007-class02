//解法一：递归调用，每个子节点加入list，最后根节点加入list，root==null表示添加完毕返回list
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root == null)
            return list;
        for(Node item : root.children)
            postorder(item);
        list.add(root.val);
        return list;
    }
}

//方法二：迭代， 后序遍历为左右根，先把根元素放入数组，然后把它的子节点入栈，循环出栈加入数组，迭代调用；
//list反转就是后序遍历的结果
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            for(Node node: root.children)
                stack.add(node);
        }
        Collections.reverse(list);
        return list;
    }
}