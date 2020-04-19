package nAryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author VITI.lewis
 * @Despriction:
 * @Date:Created in 2020/3/29 10:08 下午
 * @Modify By:
 */
public class nAryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Node> previousLayer = Arrays.asList(root);

        while (!previousLayer.isEmpty()) {
            List<Node> currentLayer = new ArrayList<>();
            List<Integer> previousVals = new ArrayList<>();
            for (Node node : previousLayer) {
                previousVals.add(node.val);
                currentLayer.addAll(node.children);
            }
            result.add(previousVals);
            previousLayer = currentLayer;
        }

        return result;
    }
}
