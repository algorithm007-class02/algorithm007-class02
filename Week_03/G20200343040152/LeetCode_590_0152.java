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
        List<Integer> nodeList = new ArrayList<>();
        // 循环
        return nodeIterator(root,nodeList);
        //nodeRecursive(root,nodeList);
        //return nodeList;
    }

    public void nodeRecursive(Node root,List<Integer> nodeList) {
        if(root == null) return;
        for(Node node:root.children) {
            nodeRecursive(node,nodeList);
        }
        nodeList.add(root.val);
    }

    public List<Integer> nodeIterator(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

      stack.add(root);
      while (!stack.isEmpty()) {
          Node node = stack.pollLast();
          output.addFirst(node.val);
          for (Node item : node.children) {
              if (item != null) {
                  stack.add(item);    
              } 
          }
      }
      return output;
    }

}