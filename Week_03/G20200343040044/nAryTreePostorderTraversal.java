package postorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author VITI.lewis
 * @Despriction:
 * @Date:Created in 2020/3/29 9:16 下午
 * @Modify By:
 */
public class nAryTreePostorderTraversal {

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        for (Node node:root.children) {
            list.addAll(postorder(node));
        }
        list.add(root.val);
        return  list;
    }

}
