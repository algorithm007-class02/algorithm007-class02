// 前序顺序遍历
// https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/

public List<Integer> preorder(Node root) {

        if(root == null){
        return list;
        }

        list.add(root.val);

        if(root.children == null){

        return list;
        }


        for (int i = 0; i < root.children.size(); i++) {
        preorder(root.children.get(i));
        }


        return list;
        }