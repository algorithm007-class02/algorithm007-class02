/**
 
 105. 从前序与中序遍历序列构造二叉树
 
 根据一棵树的前序遍历与中序遍历构造二叉树。
 
 前序遍历 preorder = [3,9,20,15,7]
 中序遍历 inorder = [9,3,15,20,7]
 
 */

struct TreeNode {
    int val;
    
    TreeNode* left;
    TreeNode* right;
    
    TreeNode(int _val): val(_val), left(NULL), right(NULL) {}
};
// 分治

class Solution {
public:
    
    TreeNode* _buildTree(vector<int>& preorder, int& pos, vector<int>& inorder, int left, int right) {
         
         if (pos >= preorder.size())
             return NULL;
         
         int i = left;
         for(; i<=right; i++) {
             if (preorder[pos] == inorder[i])
                 break;
         }
         
         TreeNode* root = new TreeNode(preorder[pos]);
         // 每执行一次，头一个元素都会失效
         if (left <= i-1) {
             pos += 1;
             root->left = _buildTree(preorder, pos, inorder, left, i-1);
         }
         
         if (right >= i+1) {
             pos += 1;
             root->right = _buildTree(preorder, pos, inorder, i+1, right);
         }
         
         return root;
     }

    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
         
        int p = 0;
        return _buildTree(preorder, p, inorder, 0, (int)(inorder.size()-1));
     }
    
};