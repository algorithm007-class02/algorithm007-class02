//后续遍历
//https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal

private List<Integer> list = new ArrayList<Integer>(1000);

public List<Integer> postorder(Node root) {

        if(root == null){
        return list;
        }

        if(root.children == null){

        list.add(root.val);

        return list;
        }


        for (int i = 0; i < root.children.size(); i++) {
        postorder(root.children.get(i));
        }

        list.add(root.val);

        return list;
        }