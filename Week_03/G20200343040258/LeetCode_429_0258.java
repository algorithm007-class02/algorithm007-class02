/*
给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

例如，给定一个 3叉树 :

 



 

返回其层序遍历:

[
     [1],
     [3,2,4],
     [5,6]
]

*/

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
     //根据level 进行add 用Map
    private Map<Integer,List> listMap = new HashMap<Integer,List>();

    public List<List<Integer>> levelOrder(Node root) {
        //根据level 进行add 用Map
       recur(root,1);
        return new ArrayList(listMap.values());
    }
    //DFS
    public void recur(Node node,int level){
        if(node == null){
            return;
        }
        if(!listMap.containsKey(level)){
            listMap.put(level,new ArrayList<Integer>());
        }
        listMap.get(level).add(node.val);
        List<Node> childrenNodes = node.children;
        if(childrenNodes != null){
                for(Node childNode : childrenNodes){
                    recur(childNode,level+1);
                }
        }
        
    }
}
//时间复杂度 o(N)
//空间复杂度  o(N)