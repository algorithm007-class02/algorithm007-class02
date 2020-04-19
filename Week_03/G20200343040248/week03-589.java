//跟前一题590的解法思路一样
//解法一：递归调用，先加入根节点，再加入子节点，root==null表示添加完毕返回list
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root == null)
            return list;
        list.add(root.val);
        for(Node item : root.children)
            postorder(item);
        return list;
    }
}
//方法二：迭代， 后序遍历为左右根，先把根元素放入数组，然后把它的子节点倒序入栈，循环出栈加入数组，迭代调用；
//先入栈的是右节点，出栈的是左节点，加入数组即为根左右
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--)
                stack.add(root.children.get(i));
        }
        return list;
    }
}