/*
给定一个 N 叉树，返回其节点值的后序遍历。

例如，给定一个 3叉树 :

 



 

返回其后序遍历: [5,6,3,2,4,1].
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
    public List<Integer> postorder(Node root) {

        List<Integer> numList = new ArrayList<Integer>();
        //递归
        if(root != null){
            recurPostorder(numList,root);
        }
        

        return numList;

    }

    public void recurPostorder(List<Integer> numList,Node root){

        List<Node> chidren = root.children;
        if(chidren != null){
            for(Node child : chidren){
                if(child != null){
                    recurPostorder(numList,child);
                }
            }
        }
        numList.add(root.val);
        
    }
}

//时间复杂度：O（N） N为树节点个数
//空间复杂度：O（2N） list 和 系统栈