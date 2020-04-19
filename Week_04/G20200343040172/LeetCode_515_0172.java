package week04.g20200343040172;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 * LeetCode-515 Find largest value in each tree row在每个树行中找最大值
 */
public class LeetCode_515_0172 {

    /**
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        int cnt = 1;
        int maxValue = Integer.MIN_VALUE;

        while (nodeList.size() > 0) {
            while (cnt > 0) {
                cnt--;
                TreeNode tmp = nodeList.removeFirst();
                maxValue = maxValue > tmp.val ? maxValue : tmp.val;
                if (tmp.left != null) {
                    nodeList.add(tmp.left);
                }
                if (tmp.right != null) {
                    nodeList.add(tmp.right);
                }
            }
            list.add(maxValue);
            maxValue = Integer.MIN_VALUE;
            cnt = nodeList.size();
        }
        return list;
    }
}
