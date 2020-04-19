package level2;

import tools.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution105 {

    static class Solution {
        private int preIndex = 0;
        int[] preorder;
        int[] inorder;
        private Map<Integer, Integer> posMap = new HashMap<>();

        private TreeNode helper(int left, int right) {
            if (left == right)
                return null;
            int rootVal = this.preorder[this.preIndex];
            TreeNode root = new TreeNode(rootVal);
            this.preIndex += 1;
            int inorderIndex = this.posMap.get(rootVal);
            // 对于中序遍历 每一级根节点的左边为左子树 右边为右子树
            root.left = helper(left, inorderIndex);
            root.right = helper(inorderIndex + 1, right);
            return root;
        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            this.inorder = inorder;
            int index = 0;
            // 只做前向遍历数组的索引字典
            for (int num : inorder) {
                posMap.put(num, index++);
            }
            return helper(0, inorder.length);
        }
    }
}
